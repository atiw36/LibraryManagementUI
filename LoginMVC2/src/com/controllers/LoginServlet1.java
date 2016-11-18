package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.UserBean;
import com.daos.UserDAO1;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// 'user' bean created
			
			UserBean user1 = new UserBean();
			// setters called
			
			user1.setBookname(request.getParameter("book"));
			
			user1 = UserDAO1.login(user1);
			System.out.println("User is "+user1);
			if (user1.isValid()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user1);
				response.sendRedirect("BookDeatails.jsp"); // logged-in page
			} else
				response.sendRedirect("NoBook.jsp"); // error page
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
