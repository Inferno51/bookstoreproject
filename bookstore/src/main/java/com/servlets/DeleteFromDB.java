package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.*;

/**
 * Servlet implementation class DeleteFromDB
 */
@WebServlet("/DeleteFromDB")
public class DeleteFromDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFromDB() {
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
		
		Book deleteFromDB = new Book();
		
		int bookID = Integer.parseInt(request.getParameter("book_id"));
		
		deleteFromDB.setBookID(bookID);
		
		com.bookstore.DAO.deleteFromDatabase(deleteFromDB);
		
		request.getRequestDispatcher("readfromdb.jsp").forward(request, response);
	}

}
