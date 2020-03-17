package com.bridgelabz.commercialdata.controller;
/**
 * @author:Hemanth Kumar
 * @date: 2020/03/17
 * @version:1.2
 * Purpose: StockAccount.java implements a data type that  might be used by a financial institution to keep track of customer information
 **/

/**
 * Here import the utility package to use the Utility class in a program.
 **/
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONException;

import com.bridgelabz.commercialdata.serviceprovider.StockAccount;
import com.bridgelabz.commercialdata.utils.InputUtility;





public class Runner 
{
	static Runner runner=new Runner ();
    static StockAccount stockaccount=new  StockAccount();
	public void stockAccountMenu() throws FileNotFoundException, JSONException, IOException
	   {
	     System.out.println("==========COMMERCIAL MANAGEMENT==========");
		 System.out.println("1:--->Do You Want to create new Account !!");
		 System.out.println("2:--->Total value of account");
		 System.out.println("3:--->Do You Want to add shares of Stock to account");
		 System.out.println("4:--->Subtract shares of stock from account");
		 System.out.println("5:--->Print the stock report");
		 int choice=InputUtility.nextInt();
		 runner.stockAccountProceed(choice);
		 
	   }
	public void stockAccountProceed(int choice) throws FileNotFoundException, JSONException, IOException
	{
		   switch(choice)
		   {
		   case 1:System.out.println("Welcome to commercial Management..");
		          System.out.println(".............................");
		          System.out.println("enter the Name of a file(use .json extension)");
		          String  name=InputUtility.next();
		          stockaccount.createAccount(name);
		          break;
		          
		   case 2:stockaccount.calculateAccount();
		          break;
		          
		   case 3:System.out.println("Enter the amount that you want to add to Account");
		          int amt=InputUtility.nextInt();
		          System.out.println("Enter the symbol that you want to buy for Account");
		          String sym=InputUtility.next();
			      stockaccount.buy(amt, sym);
			      break;
		   case 4:System.out.println("Enter the amount that you want to Remove from Account");
	              int amt1=InputUtility.nextInt();
	              System.out.println("Enter the symbol that you want to remove and Add for Account");
	              String sym1=InputUtility.next();
		          stockaccount.sell(amt1, sym1);
		          break;
		   case 5:stockaccount.printReport();
			      break;
		   }
	
}
	public static void main(String[] args) throws FileNotFoundException, JSONException, IOException 
	{
		runner.stockAccountMenu();
	}
}
