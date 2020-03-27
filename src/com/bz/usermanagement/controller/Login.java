package com.bz.usermanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
//@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Login() {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println(name);
		System.out.println(password);
		HttpSession sess = request.getSession();
		if (sess != null) {
			String sessname = (String) sess.getAttribute("password");
			System.out.println("sessname" + sessname);
			if (password.equals(sessname)) {
				response.sendRedirect("View.jsp");
				System.out.println("processed");
			} else {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
				 out= response.getWriter();
				out.println("<font color=red>Either user name or password is wrong.</font>");
				rd.include(request, response);
			}
		}

	}
}