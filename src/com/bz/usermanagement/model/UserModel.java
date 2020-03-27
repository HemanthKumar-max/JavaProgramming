package com.bz.usermanagement.model;

public class UserModel {
	String name;
	String password;
	String country;
	String phone;

	public UserModel() {

	}

	public UserModel(String name, String password, String country, String phone) {
		super();
		this.name = name;
		this.password = password;
		this.country = country;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
