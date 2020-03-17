package com.bridgelabz.companyshares.controller;
/**
 * @author:Hemanth Kumar
 * @date: 2020/03/17
 * @version:1.2
 * Purpose: Maintain the List of CompanyShares in a Linked List So new CompanyShares can  be added or removed easily. Do not use any Collection Library to implement Linked 
 * Further maintain the Stock Symbol Purchased or Sold in a Stack implemented using Linked List to indicate transactions done. 8
 * rther maintain DateTime of the transaction in a Queue implemented using Linked  List to indicate when the transactions were done. 
 *  **/

/**
 * Here import the utility package to use the Utility class in a program.
 **/
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

import com.bridgelabz.companyshares.model.CompanyShareModel;
import com.bridgelabz.companyshares.model.LinkedList;
import com.bridgelabz.companyshares.model.StackLinkedList;
import com.bridgelabz.companyshares.serviceprovider.CompanyShareService;
import com.bridgelabz.companyshares.utils.InputUtility;

public class Runner {

	static Runner runner = new Runner();
	static CompanyShareService companyservice = new CompanyShareService();
	static String fileName;

	public void companySharesMenu() throws FileNotFoundException, JSONException, IOException {
		System.out.println("========== COMPANY SHARES USING LINKEDLIST==========");
		System.out.println("1:--->Do You Want to add the company info And Shares to the List!!");
		System.out.println("2:--->Do you want to  buy stock symbol for the company");
		System.out.println("3:---->Do you want to sell stock symbol to other company");
		System.out.println("4:---->Do You want to view the company info");
		System.out.println("5:---->Do you want to enter the transaction time");
		int choice = InputUtility.nextInt();
		runner.companySharesTransmit(choice);

	}

	public void companySharesTransmit(int choice) throws FileNotFoundException, JSONException, IOException {
		switch (choice) {
		
		case 1:System.out.println("Please enter the fileName");
		       fileName=InputUtility.next(); 
			   companyservice.addCompanyDetails(fileName);
		       break;
		case 2: System.out.println("Please enter the fileName");
	            fileName=InputUtility.next(); 
	            companyservice.stockSymbolPurchased(fileName);
	            break;
		case 3: System.out.println("Please enter the fileName");
                fileName=InputUtility.next(); 
                companyservice.stockSymbolSold(fileName);
		        break;
	    case 4:System.out.println("enter the filename");
	           fileName=InputUtility.next(); 
	    	   companyservice.displayInfo(fileName);      
		       break;
		       
	    case 5: System.out.println("enter the filename");
                fileName=InputUtility.next(); 
 	            companyservice.addCompanyDateTimeDetails(fileName);      
	            break;
	    	
		}
	}
	public void interpreter(String fileName,LinkedList al1) throws FileNotFoundException, JSONException, IOException
	{
		System.out.println("1:to add");
		System.out.println("2:to remove");
		System.out.println("3:to exit");
		int choice=InputUtility.nextInt();
		runner.interpreterOptions(fileName, al1, choice);
	}
	public void interpreterSymbol(String fileName,StackLinkedList al1) throws FileNotFoundException, JSONException, IOException
	{
		System.out.println("1:to buy symbol");
		System.out.println("2:to sell sybolm");
		System.out.println("3:to exit");
		int choice=InputUtility.nextInt();
		runner.interpreterOptionsSymbol(fileName, al1, choice);
	}
	
	public void interpreterOptionsSymbol(String fileName,StackLinkedList al1,int choice) throws FileNotFoundException, JSONException, IOException
	{
		switch(choice)
		{
		case 1: companyservice.stockSymbolPurchased(fileName);
	            break;
		case 2:companyservice.stockSymbolSold(fileName);
		       break;
		case 3:runner.companySharesMenu();
		}
	}
	
	
	
	
	
	public void interpreterOptions(String fileName,LinkedList al1,int choice) throws FileNotFoundException, JSONException, IOException
	{
		switch(choice)
		{
		case 1: companyservice.addCompanyDetails(fileName);
	            break;
		case 2:companyservice.removeCompanyShares(fileName, al1);
		       break;
		case 3:runner.companySharesMenu();
		}
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException, JSONException, IOException 
	{
	  runner.companySharesMenu();	
	}
	
	
}
	
	
	
	
	
	
	