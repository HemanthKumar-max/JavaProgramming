package com.bridgelabz.commercialdata.model;



public class CommercialModel
{
	String name;
	int cash;
	int n;
	int shares;
	String[] stocks;
	String symbol;
	public CommercialModel(String name, int cash, int n, int shares, String[] stocks,String symbol) {
		super();
		this.name = name;
		this.cash = cash;
		this.n = n;
		this.shares = shares;
		this.stocks = stocks;
		this.symbol=symbol;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getShares() {
		return shares;
	}
	public void setShares(int shares) {
		this.shares = shares;
	}
	public String[] getStocks() {
		return stocks;
	}
	public void setStocks(String[] stocks) {
		this.stocks = stocks;
	}
	public String getSymbol(){
		return symbol;
	}
	public void setSymbol(String symbol)
	{
	this.symbol=symbol;
	}

	
	
	
	
}