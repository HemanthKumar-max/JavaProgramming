package com.bridgelabz.inventorymanager.controller;
/**
 * @author:Hemanth Kumar
 * @date: 2020/03/17
 * @version:1.2
 * Purpose: Extend the above program to Create InventoryManager to manage the Inventory. The Inventory Manager will use InventoryFactory to create Inventory Object from JSON
 **/

/**
 * Here import the utility package to use the Utility class in a program.
 **/



import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.bridgelabz.Addressbook.utils.InputUtility;
import com.bridgelabz.inventorymanager.serviceprovider.InventoryManager;
import com.bridgelabz.inventorymanager.utils.FileUtility;

public class Runner {
	static InventoryManager inventmanager = new InventoryManager();
	static Runner runner = new Runner();
	static FileUtility file=new FileUtility();
	static String name;

	public void inventoryManager() throws FileNotFoundException, IOException, JSONException {
		System.out.println("===========WELCOME TO INVENTORY MANAGER=============");
		System.out.println("Please choose any one in the following");
		System.out.println("Press:1--->Rice(type1)");
		System.out.println("Press:2--->Wheat(type2)");
		System.out.println("Press:3--->Pulses(type3)");
		System.out.println("Press:4--->To open existing file.");
		int choice = InputUtility.nextInt();
		runner.chooseInventory(choice);

	}

	
	
	
	public void chooseInventory(int choice) throws FileNotFoundException, IOException, JSONException {
		switch (choice) {
		case 1:
			System.out.println("Please enter the filename(use .json extension)");
			name = InputUtility.next();
			inventmanager.addItemDetails(name);
			break;
		case 2:
			name = InputUtility.next();
			inventmanager.addItemDetails(name);
			break;
		case 3:
            name = InputUtility.next();
			inventmanager.addItemDetails(name);
            break;
		case 4:
			System.out.println("Please enter the filename to open(give .json extension)");
			String fileName = InputUtility.next();
			file.ReadJsonFile(fileName, null);
			break;
		}
	}
	
	
	public void inventoryManagerOption(int choice, String fileName, JSONObject jobj)
			throws JSONException, FileNotFoundException, IOException {
		switch (choice) {
		case 1:
			file.ReadJsonFile(fileName, jobj);
			break;
		case 2:
			inventmanager.getPriceAndWeight(fileName, jobj);
			break;
		}
	}

	public void inventoryManagerDetails(String fileName, JSONObject jobj)
			throws JSONException, FileNotFoundException, IOException {
		System.out.println("Available Info:------>");
		System.out.println("==============================");
		System.out.println("Press 1:------>GetDetails");
		System.out.println("Press 2:------>GetTotalPrice/GetTotalWeight");
		int choice = InputUtility.nextInt();
		runner.inventoryManagerOption(choice, fileName, jobj);
	}
	
	
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException, JSONException 
	{
       runner.inventoryManager();		
	}
}
	
	    
	    
		
		
		
	
