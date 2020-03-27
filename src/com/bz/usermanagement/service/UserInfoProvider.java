package com.bz.usermanagement.service;

import java.sql.SQLException;

import com.bz.usermanagement.model.UserModel;
import com.bz.usermanagement.repository.UserRepo;

public class UserInfoProvider implements UserService
{

	static UserRepo ur = new UserRepo();
	static UserModel um=new UserModel();
	static int rs;
	
	@Override
	public int addDetails(String name, String password, String country, String phone) {
		try {

			UserModel um = new UserModel(name, password, country, phone);
			rs = ur.addUserRepo(um);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	
	@Override
	public UserModel getDetails(String password) {
		try {
			um = ur.getUserDetails(password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return um;
	}
}
	

	
	


