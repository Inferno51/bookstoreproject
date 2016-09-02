package com.bookstore;

import java.sql.*;
import java.util.ArrayList;

public class DAO {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";
	
	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP = null;
	static ResultSet RES = null;
	public static ArrayList<Book> ourBooks = new ArrayList<>();
	
	public static void connToDB() {
		try {
			Class.forName(JDBC_DRIVER);
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} // Try connection statement
	} // connToDB
	
	public static void readFromDB() {
		connToDB();
		
		
		
		try {
			STMT = CONN.createStatement();
			RES = STMT.executeQuery("SELECT * FROM products.books;");
			
			while (RES.next()) {
				Book myBook = new Book();
				myBook.setBookID(RES.getInt("book_id"));
				myBook.setBookName(RES.getString("book_name"));
				myBook.setBookPrice(RES.getDouble("book_price"));
				myBook.setBookCount(RES.getInt("book_inv_count"));
				myBook.setBookDesc(RES.getString("book_desc"));
				
				ourBooks.add(myBook);
				
			}
			
			for (Book book : ourBooks) {
				System.out.println(book.toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // readFromDB
	
	private static String insertIntoTable = "INSERT INTO `products`.`books` "
			+ "(book_name, book_price, book_inv_count, book_desc)"
			+ " VALUES "
			+ "(?, ?, ?, ?)";
	
	public static void writeToDB(Book newBook) {
		
		Book bookToAdd = new Book();
		
		bookToAdd = newBook;
		
		try {
			connToDB();
			
			PREP = CONN.prepareStatement(insertIntoTable);
			
			PREP.setString(1, bookToAdd.getBookName());
			PREP.setDouble(2, bookToAdd.getBookPrice());
			PREP.setInt(3, bookToAdd.getBookCount());
			PREP.setString(4, bookToAdd.getBookDesc());
			
			System.out.println(PREP);
			
			PREP.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static String updateDB = ("UPDATE `products`.`books` SET `book_name` = ?, `book_price` = ?, `book_inv_count` = ?, `book_desc` = ? WHERE `book_id` = ?");
	
	public static void updateDB(Book newBook) {
		
		readFromDB();
		
		Book bookToUpdate = new Book();
		
		bookToUpdate = newBook;
		
		try {
			PREP = CONN.prepareStatement(updateDB);
			
			PREP.setString(1, bookToUpdate.getBookName());
			PREP.setDouble(2, bookToUpdate.getBookPrice());
			PREP.setInt(3, bookToUpdate.getBookCount());
			PREP.setString(4, bookToUpdate.getBookDesc());
			PREP.setInt(5, bookToUpdate.getBookID());
			
			PREP.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	} // updateDB
	
	public static void deleteFromDatabase(Book newBook) {
		Book bookToDelete = new Book();
		bookToDelete = newBook;
		
		try {
			connToDB();
			PREP = CONN.prepareStatement("DELETE FROM `products`.`books` WHERE book_ID = ?");
			PREP.setInt(1, bookToDelete.getBookID());
			PREP.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // deleteFromDatabase
	
	public static void deleteFromDatabaseList(Book newBook) {
		Book bookToDelete = new Book();
		bookToDelete = newBook;
		
		try {
			connToDB();
			PREP = CONN.prepareStatement("DELETE FROM `products`.`books` WHERE book_name = ?");
			PREP.setString(1, bookToDelete.getBookName());
			PREP.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // deleteFromDatabase
}
