package com.bz.usermanagement.service;

import com.bz.usermanagement.model.UserModel;

public interface UserService 
{
	public int addDetails(String name, String password, String country, String phone);

	public UserModel getDetails(String password);

}
