package com.bz.usermanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bz.usermanagement.model.UserModel;
import com.bz.usermanagement.repository.UserRepo;
import com.bz.usermanagement.service.UserInfoProvider;
import com.bz.usermanagement.service.UserService;



//@WebServlet("/Registration")  
public class Registration extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    static UserRepo ur=new UserRepo();
	static UserService us=ur.factoryclass();
	static UserInfoProvider ui=new UserInfoProvider();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");
		System.out.println(name);
		System.out.println(password);
		System.out.println(country);
		System.out.println(phone);
		System.out.println("comming");
		int rs = us.addDetails(name, password, country, phone);
		if (rs > 0) {
			HttpSession sess = request.getSession();
			sess.setAttribute("password", password);
			System.out.println("<p>Record saved successfully!</p>");
			System.out.println("your data has been successfully stored");
			response.sendRedirect("Process.html");
		} else {
			out.println("Sorry! unable to save record");
		}
	          
	          
}
}