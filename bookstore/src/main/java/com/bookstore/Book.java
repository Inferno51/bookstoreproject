package com.bookstore;

public class Book {
	
	private int bookID = 0;
	private int bookCount = 0;
	private double bookPrice = 0.0d;
	private String bookName = null;
	private String bookDesc = null;
	
	// Constructor
	public Book(int bookID, int bookCount, double bookPrice, String bookName, String bookDesc) {
		super();
		this.bookID = bookID;
		this.bookCount = bookCount;
		this.bookPrice = bookPrice;
		this.bookName = bookName;
		this.bookDesc = bookDesc;
	} // Constructor

	// Blank constructor
	public Book() {
		super();
	} // Blank constructor

	
	// Getters and setters
	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	// Getters and setters
	

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", bookCount=" + bookCount + ", bookPrice=" + bookPrice + ", bookName="
				+ bookName + ", bookDesc=" + bookDesc + "]";
	} // toString method
	
	
	
}
