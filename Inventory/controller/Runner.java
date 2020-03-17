package com.bridgelabz.Inventory.controller;
/**
 * @author:Hemanth Kumar
 * @date: 2020/03/17
 * @version:1.2
 * Purpose:a. Desc -> Create a JSON file having Inventory Details for Rice, Pulses and Wheats with properties name, weight, price per kg.  
 **/

/**
 * Here import the utility package to use the Utility class in a program.
 **/
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.bridgelabz.Addressbook.utils.InputUtility;
import com.bridgelabz.Inventory.serviceprovider.InventoryItemService;
import com.bridgelabz.Inventory.utils.FileUtility;

public class Runner {

	static InventoryItemService inventorycont = new InventoryItemService();
	static Runner runner = new Runner();
	FileUtility file = new FileUtility();
	static String name;
	
	

	public void inventoryView() throws JSONException, FileNotFoundException, IOException {
		System.out.println("enter your choice that you want to fill in Inventory Details");
		System.out.println("=========================================================");
		System.out.println("Press 1:---->Rice ");
		System.out.println("Press 2:---->wheat");
		System.out.println("Press 3:---->Pulses");
		System.out.println("Press 4:----->other(to see details of existing)");
		System.out.println("==========================================================");
		int ch = InputUtility.nextInt();
		runner.inventoryMenu(ch);
	}

	public void inventoryMenu(int choice) throws JSONException, FileNotFoundException, IOException {
		switch (choice){
		case 1:
			System.out.println(" Please enter the file name of respective Inventory(Use .json extension!!)");
			System.out.println("options to fill:example(Rice,wheat,pulses)");
			name = InputUtility.next();
			inventorycont.addItemDetails(name);
			break;
		case 2:
			System.out.println(" Please enter the file name of respective Inventory(Use .json extension!!)");
			System.out.println("options to fill:example(Rice,wheat,pulses)");
			name = InputUtility.next();
			inventorycont.addItemDetails(name);
			break;
		case 3:
			System.out.println(" Please enter the file name of respective Inventory(Use .json extension!!)");
			System.out.println("options to fill:example(Rice,wheat,pulses)");
			name = InputUtility.next();
			inventorycont.addItemDetails(name);
			break;
		case 4:
			System.out.println("Please enter the filename to open(give .json extension)");
			String fileName = InputUtility.next();
			file.ReadJsonFile(fileName);
			break;

		default:
			System.out.println("Please enter the valid input ..");
			runner.inventoryView();
			break;
		}
	}

	public void inventoryOption(int choice, String fileName, JSONObject jobj)
			throws JSONException, FileNotFoundException, IOException {
		switch (choice) {
		case 1:
			file.ReadJsonFile(fileName);
			break;
		case 2:
			inventorycont.getPriceAndWeight(fileName, jobj);
			break;
		}
	}

	public void inventoryDetails(String fileName, JSONObject jobj)
			throws JSONException, FileNotFoundException, IOException {
		System.out.println("Available Info:------>");
		System.out.println("==============================");
		System.out.println("Press 1:------>GetDetails");
		System.out.println("Press 2:------>GetTotalPrice/GetTotalWeight");
		int choice = InputUtility.nextInt();
		runner.inventoryOption(choice, fileName, jobj);
	}

	public static void main(String[] args) throws JSONException, FileNotFoundException, IOException {
		runner.inventoryView();
	}
}
