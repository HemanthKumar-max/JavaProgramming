package com.bz.usermanagement.filter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppContextListener implements ServletContextListener
{
	 public void contextInitialized(ServletContextEvent servletContextEvent) {
	    	ServletContext context = servletContextEvent.getServletContext();
	    	
	    	String url = context.getInitParameter("DBURL");
	    	String user = context.getInitParameter("DBUSER");
	    	String password = context.getInitParameter("DBPWD");
	    	
	    	//create database connection from init parameters and set it to context
	    	DBConnectionListener dbManager = new DBConnectionListener(url, user, password);
	    	context.setAttribute("DBManager", dbManager);
	    	System.out.println("Database connection initialized for Application.");
	    }

	    public void contextDestroyed(ServletContextEvent servletContextEvent) {
	    	ServletContext ctx = servletContextEvent.getServletContext();
	    	DBConnectionListener dbManager = (DBConnectionListener) ctx.getAttribute("DBManager");
	    	dbManager.closeConnection();
    	System.out.println("Database connection closed for Application.");
   	
}
}