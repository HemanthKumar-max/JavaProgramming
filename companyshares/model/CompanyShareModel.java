package com.bridgelabz.companyshares.model;

public class CompanyShareModel {
	String companyName;
	int shares;
	
	public  CompanyShareModel(String companyName, int shares) {
		super();
		this.companyName = companyName;
		this.shares = shares;
		
	}
	public  CompanyShareModel()
	{
		
	}
	
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getShares() {
		return shares;
	}
	public void setShares(int shares) {
		this.shares = shares;
	}
	


	}

