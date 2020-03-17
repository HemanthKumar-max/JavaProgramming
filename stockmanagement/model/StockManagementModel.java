package com.bridgelabz.stockmanagement.model;

public class StockManagementModel 
{
String companyName;
int numberOfStocks;
String industry;//material,financial,information technoloy
public StockManagementModel(String companyName, int numberOfStocks, String industry) {
	super();
	this.companyName = companyName;
	this.numberOfStocks = numberOfStocks;
	this.industry = industry;
}
public String tostring()
{
	return "companyName="+this.companyName+"numberOfStocks="+this.numberOfStocks+"industry="+this.industry;
}





public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public int getNumberOfStocks() {
	return numberOfStocks;
}
public void setNumberOfStocks(int numberOfStocks) {
	this.numberOfStocks = numberOfStocks;
}
public String getIndustry() {
	return industry;
}
public void setIndustry(String industry) {
	this.industry = industry;
}

}