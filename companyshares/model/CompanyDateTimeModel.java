package com.bridgelabz.companyshares.model;

public class CompanyDateTimeModel 
{

int date;
int time;
int transactionAmt;
public CompanyDateTimeModel(int date, int time, int transactionAmt) {
	super();
	this.date = date;
	this.time = time;
	this.transactionAmt = transactionAmt;
}
public int getDate() {
	return date;
}
public void setDate(int date) {
	this.date = date;
}
public int getTime() {
	return time;
}
public void setTime(int time) {
	this.time = time;
}
public int getTransactionAmt() {
	return transactionAmt;
}
public void setTransactionAmt(int transactionAmt) {
	this.transactionAmt = transactionAmt;
}



}