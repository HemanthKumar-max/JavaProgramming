package com.bridgelabz.stockmanagement.model;

public class StockModel
{
String stockName;
int numberOfShare;
int sharePrice;
public StockModel(String stockName, int numberOfShare, int sharePrice) {
	super();
	this.stockName = stockName;
	this.numberOfShare = numberOfShare;
	this.sharePrice = sharePrice;
}

public StockModel() {
	
}

public String getStockName() {
	return stockName;
}
public void setStockName(String stockName) {
	this.stockName = stockName;
}
public int getNumberOfShare() {
	return numberOfShare;
}
public void setNumberOfShare(int numberOfShare) {
	this.numberOfShare = numberOfShare;
}
public int getSharePrice() {
	return sharePrice;
}
public void setSharePrice(int sharePrice) {
	this.sharePrice = sharePrice;
}




}
