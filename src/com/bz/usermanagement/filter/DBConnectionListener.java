package com.bz.usermanagement.filter;

import java.sql.Connection;

public class DBConnectionListener 
{
	private String dbURL;
	private String user;
	private String password;
	private Connection con;
	
	public DBConnectionListener(String url, String user, String password){
		this.dbURL=url;
		this.user=user;
		this.password=password;
		//create db connection now
		
	}
	
	public Connection getConnection(){
		return this.con;
	}
	
	public void closeConnection(){
		//close DB connection here
	}
}
