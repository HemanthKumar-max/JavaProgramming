package com.bridgelabz.companyshares.model;

public class CompanySymbolModel 
{
	String buyer;
	String symbol;
	String seller;
	public CompanySymbolModel(String buyer, String symbol, String seller) {
		super();
		this.buyer = buyer;
		this.symbol = symbol;
		this.seller = seller;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	
}
