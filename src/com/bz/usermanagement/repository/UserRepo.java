package com.bz.usermanagement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bz.usermanagement.config.UserDBConnection;
import com.bz.usermanagement.model.UserModel;
import com.bz.usermanagement.service.UserInfoProvider;

public class UserRepo 
{
	UserDBConnection ucon = new UserDBConnection();
	Connection con = UserDBConnection.getConnection();
	PreparedStatement prepstmt;

	public UserInfoProvider factoryclass() {
		UserInfoProvider userinfoprovider = new UserInfoProvider();
		return userinfoprovider;
	}
	

	public int addUserRepo(UserModel um) throws SQLException {
		System.out.println("inside repo");
		String add = "INSERT INTO info(name,password,country,phone) VALUES(?,?,?,?)";
		prepstmt = con.prepareStatement(add);
		prepstmt.setString(1, um.getName());
		prepstmt.setString(2, um.getPassword());
		prepstmt.setString(3, um.getCountry());
		prepstmt.setString(4, um.getPhone());
		int rs = prepstmt.executeUpdate();
		if (rs > 0) {
			System.out.println("data is inserted into database");
		}
		return rs;
	}
	
	
	public UserModel getUserDetails(String password) throws SQLException {
		UserModel um = null;
		String selectquery = "Select * from info where password=?";
		prepstmt = con.prepareStatement(selectquery);
		prepstmt.setString(1, password);
		ResultSet rs = prepstmt.executeQuery();
		if (rs.next()) {
			um = new UserModel();
			um.setName(rs.getString("name"));
			um.setPassword(rs.getString("password"));
			um.setCountry(rs.getString("country"));
			um.setPhone(rs.getString("phone"));
		}
		return um;
		
		
		
	}
}