package com.fundoonote.noteapi.model;

public class Token {
	String firstname;
	String lastname;
	String email;
	int token;
	String password;

	public Token() {

	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString()
	{
		return "firstname="+this.firstname+"lastname="+this.lastname+"email="+this.email+"token="+this.token+"password="+this.password;
	}
}