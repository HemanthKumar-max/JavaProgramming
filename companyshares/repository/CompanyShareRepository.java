package com.bridgelabz.companyshares.repository;



import com.bridgelabz.companyshares.model.LinkedList;


public interface CompanyShareRepository {
public void addCompanyDetails(String fileName);
public void removeCompanyShares(String fileName, LinkedList al12);
public void stockSymbolPurchased(String fileName);
public void stockSymbolSold(String fileName);
public void displayInfo(String fileName);

public void addCompanyDateTimeDetails(String fileName);



}
