package com.bridgelabz.stockmanagement.controller;
/**
 * @author:Hemanth Kumar
 * @date: 2020/03/17
 * @version:1.2
 * Purpose:> Write a program to read in Stock Names, Number of Share, Share Price. Print a Stock Report with total value of each Stock and the total value of Stock. 
 **/

/**
 * Here import the utility package to use the Utility class in a program.
 **/
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.bridgelabz.stockmanagement.serviceprovider.StockManagement;
import com.bridgelabz.stockmanagement.utils.FileUtility;
import com.bridgelabz.stockmanagement.utils.InputUtility;

public class Runner 
{ 
	static FileUtility file=new FileUtility();
	static StockManagement stockmanagement=new StockManagement();
	static Runner runner =new Runner(); 
	
	public void stockMenu() throws FileNotFoundException, JSONException, IOException
   {
     System.out.println("==========STOCK-MANAGEMENT==========");
	 System.out.println("1:--->Do you want to enter the new stock!!");
	 System.out.println("2:--->Do you want to see the existing stock!!");
	 
	 int choice=InputUtility.nextInt();
	 runner.stockMenuOptions(choice);
   }


   public void stockMenuOptions(int choice) throws FileNotFoundException, JSONException, IOException
{
	   switch(choice)
	   {
	   case 1:System.out.println("Welcome to Stock Management..");
	          System.out.println(".............................");
	          System.out.println("enter the Name of a file(use .json extension)");
	          String  name=InputUtility.next();
	          stockmanagement.addStockDetails(name);
	          break;
	          
	   case 2:System.out.println("Please enter the filename!!!");
	       String fileName=InputUtility.next();
		   runner.stockManagementMenu(fileName, null);    
	   }
}
   
   
   
   public void stockManagementOption(int choice, String fileName, JSONObject jobj)
			throws JSONException, FileNotFoundException, IOException {
		switch (choice) {
		case 1:file.ReadJsonFile(fileName, jobj);
			   break;
		case 2:stockmanagement.getSharePriceDetails(fileName,jobj);
		       break;
		case 3:stockmanagement.getTotalShare(fileName, jobj);
		       break;
		case 4:stockmanagement.getTotalPrice(fileName, jobj);
		       break;
		case 5: System.out.println("Thank you!!!");
			    System.exit(0);
		      
		}
	}
   
   public void stockManagementMenu(String fileName,JSONObject jobj) throws FileNotFoundException, JSONException, IOException
   {
	   System.out.println("=============================");
	   System.out.println("Press 1:--->To see share details");
	   System.out.println("Press 2:--->To see sharePrice details");
	   System.out.println("Press 3:--->To see the TotalValue of share");
	   System.out.println("Press 4:--->To see the TotalValue of price");
	   System.out.println("Press 5:--->To exit");
	   int choice=InputUtility.nextInt();
	   runner.stockManagementOption(choice, fileName, jobj);
   }
   
   
   
   
   
  
   
   
   
   
   
   
   public static void main(String[] args) throws FileNotFoundException, JSONException, IOException
   {
	runner.stockMenu();
}





}
