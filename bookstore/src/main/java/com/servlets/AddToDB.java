package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.Book;

/**
 * Servlet implementation class AddToDB
 */
@WebServlet("/AddToDB")
public class AddToDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book addToDB = new Book();
		
		double bookPrice = Double.parseDouble(request.getParameter("book_price"));
		int bookCount = Integer.parseInt(request.getParameter("book_count"));
		
		addToDB.setBookName(request.getParameter("book_name"));
		addToDB.setBookPrice(bookPrice);
		addToDB.setBookCount(bookCount);
		addToDB.setBookDesc(request.getParameter("book_desc"));
		
		com.bookstore.DAO.writeToDB(addToDB);
		
		request.getRequestDispatcher("addbook.html").forward(request, response);
		
	}

}