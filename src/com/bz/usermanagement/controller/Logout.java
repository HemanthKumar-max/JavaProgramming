package com.bz.usermanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bz.usermanagement.filter.AppContextListener;

/**
 * Servlet implementation class Logout
 */
//@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * Default constructor.
	 */
	public Logout() {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		System.out.println("password="+session.getAttribute("password"));
    	if(session != null){
    		session.invalidate();
    		
    	}
    	response.sendRedirect("index.html");	
		
	

	}

}
