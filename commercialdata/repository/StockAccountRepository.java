package com.bridgelabz.commercialdata.repository;

public interface StockAccountRepository 
{
public void createAccount(String fileName);
public void calculateAccount();
public void buy(int amount,String symbol);
public void sell(int amount,String symbol);
public void printReport();

}
