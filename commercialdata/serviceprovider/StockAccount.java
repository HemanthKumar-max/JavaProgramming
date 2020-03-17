package com.bridgelabz.commercialdata.serviceprovider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.bridgelabz.commercialdata.controller.Runner;
import com.bridgelabz.commercialdata.model.CommercialModel;
import com.bridgelabz.commercialdata.repository.StockAccountRepository;
import com.bridgelabz.commercialdata.utils.FileUtility;
import com.bridgelabz.commercialdata.utils.InputUtility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class StockAccount implements StockAccountRepository {
	private String name;
	private int cash;
	private int numofstock;
	private int shares;
	private String[] stocks;
	private String symbol;
	static FileUtility file = new FileUtility();
	static JSONObject jobj = new JSONObject();
	static JSONArray jsonarray = new JSONArray();
	static ArrayList<CommercialModel> almod = new ArrayList<>();
	
	
	static HashMap<String,ArrayList<CommercialModel>> hm=new HashMap<>();
	double priceEachstock = 200.0;
	static Runner runner = new Runner();

	
	
	
	@Override
	/**An instance method createAccount, to  create the  new stockAccount by creating a new JSON File
	 *  and adding the new StockAccount data into the JSON File
	 * 
	 */
	public void createAccount(String fileName) {
		try {
			System.out.println("Enter the Name of Company");
			name = InputUtility.next();
			System.out.println("Enter the cash");
			cash = InputUtility.nextInt();
			System.out.println("enter the symbol of company");
			symbol = InputUtility.next();
			System.out.println("enter the number of stock");
			numofstock = InputUtility.nextInt();
			System.out.println("Enter the shares");
			shares = InputUtility.nextInt();
			stocks = new String[numofstock];
			System.out.println("enter the stocks");
			for (int i = 0; i < numofstock; i++) {
				stocks[i] = InputUtility.next();
			}
			System.out.println(shares);
			System.out.println(stocks);
			CommercialModel comModel = new CommercialModel(name, cash, numofstock, shares, stocks, symbol);
			almod.add(comModel);
			hm.put("CreateAccount", almod);
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String response = gson.toJson(hm);
			System.out.println(response);
            file.writeToFileString(fileName, response);
			System.out.println("========AccountDetails========");
			System.out.println("Name:" + comModel.getName());
			System.out.println("Symbol:" + comModel.getSymbol());
			System.out.println("cash-Deposited:" + comModel.getCash());
			System.out.println("NumberOfStocks:" + comModel.getN());
			System.out.println("Shares:" + comModel.getShares());
			System.out.println("Stocks:" + Arrays.toString(comModel.getStocks()));
			System.out.println("===============================");
			System.out.println("Your account has been created!!");
			runner.stockAccountMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	/**An instance method calculateAccount(),to calculate the total value of each stock.
	 * 
	 */
	public void calculateAccount() {
		try {
			System.out.println("====TotalValue========");
			System.out.println("Name:" + name);
			double total = cash;
			for (int i = 0; i < numofstock; i++) {
				int amount = shares;
				total += amount * priceEachstock;
			}
			System.out.println("=======================");
			System.out.println("TotalAccount value:" + total);
			System.out.println("=======================");
			runner.stockAccountMenu();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	/**An instance method buy(),to add the shares to stockaccount.
	 * 
	 */
	public void buy(int amount, String symbol) {
		try {
			int newcash = amount;
			String newsymbol = symbol;
			JSONObject jo = new JSONObject();
			System.out.println("enter the fileName to open(Use .json extension)");
			String fileName = InputUtility.next();
			JSONObject mainobj = file.ReadJsonFile(fileName, jobj);
			System.out.println("--->" + mainobj);
			JSONArray older = mainobj.getJSONArray("CreateAccount");
			for (int i = 0; i < older.length(); i++) {
				int oldshare = Integer.parseInt(older.getJSONObject(i).getString("shares"));
				System.out.println("-->"+oldshare);
				int oldcash = Integer.parseInt(older.getJSONObject(i).getString("cash"));
				String oldsymbol = older.getJSONObject(i).getString("symbol");
				System.out.println("enter the share that you want to add");
				int newshare = InputUtility.nextInt();
				int sharetotal = newshare + oldshare;
				int cashtotal = oldcash + newcash;
				String symboltotal = oldsymbol + newsymbol;
				String oldshare1=String.valueOf(oldshare);
				String oldcash1=String.valueOf(oldcash);
				String oldsymbol1=String.valueOf(oldsymbol);
				String conshare = String.valueOf(sharetotal);
				String concash = String.valueOf(cashtotal);
				String jSONString = mainobj.toString();
				String newString = jSONString.replace(oldshare1, conshare);
				String newString1 = newString.replace(oldcash1, concash);
				String newString2 = newString1.replace(oldsymbol1, symboltotal);
				System.out.println("StockAccount---->" + newString2);
			
				System.out.println("enter the new Filename to save");
				String newName = InputUtility.next();
				file.writeToFileString(newName, newString2);
				runner.stockAccountMenu();

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@Override
	/**An instance method sell(),to remove  the shares from the stockaccount .
	 * 
	 */
	public void sell(int amount, String symbol) {
		try {
		int newcash = amount;
		String newsymbol = symbol;
		JSONObject jo = new JSONObject();
		System.out.println("enter the fileName to open(Use .json extension)");
		String fileName = InputUtility.next();
		JSONObject mainobj;
		mainobj = file.ReadJsonFile(fileName, jobj);
		System.out.println("--->" + mainobj);
		JSONArray older = mainobj.getJSONArray("CreateAccount");
		for (int i = 0; i < older.length(); i++) {
			int oldshare = Integer.parseInt(older.getJSONObject(i).getString("shares"));
			int oldcash = Integer.parseInt(older.getJSONObject(i).getString("cash"));
			String oldsymbol = older.getJSONObject(i).getString("symbol");
			System.out.println("enter the share that you want to Remove from account");
			int newshare = InputUtility.nextInt();
			int sharetotal =  oldshare-newshare;
			int cashtotal = oldcash - newcash;
			
			String oldshare1=String.valueOf(oldshare);
			String oldcash1=String.valueOf(oldcash);
			String oldsymbol1=String.valueOf(oldsymbol);
			String conshare = String.valueOf(sharetotal);
			String concash = String.valueOf(cashtotal);
			String jSONString = mainobj.toString();
			String newString = jSONString.replace(oldshare1, conshare);
			String newString1 = newString.replace(oldcash1, concash);
			String newString2 = newString1.replace(oldsymbol1, newsymbol);
			System.out.println("StockAccount---->" + newString2);
			
			System.out.println("enter the new filename");
			String newName = InputUtility.next();
			file.writeToFileString(newName, newString2);
			runner.stockAccountMenu();
		}
		} catch (FileNotFoundException e) {
		   e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
		  e.printStackTrace();
		}
		
		
		
		}	
		

	

	@Override
	/**An instance method printreport(),to print the total value of stock and calculating value of eachstock.
	 * 
	 */
	public void printReport() {
		System.out.println("Enter the existing fileName To print stock report!!");
		String fileName=InputUtility.next();
		try {
			JSONObject mainobj = file.ReadJsonFile(fileName, jobj);
			System.out.println(mainobj);
			JSONArray older = mainobj.getJSONArray("CreateAccount");
			for (int i = 0; i < older.length(); i++) {
				
			System.out.println("=================STOCK-REPORT=================");
				System.out.println("Name:  "+older.getJSONObject(i).getString("name"));
				System.out.println("Shares:"+older.getJSONObject(i).getString("shares"));
				System.out.println("symbol:"+older.getJSONObject(i).getString("symbol"));
				System.out.println("cash:  "+older.getJSONObject(i).getString("cash"));
				System.out.println("NumberofStocks:"+older.getJSONObject(i).getString("n"));
				System.out.println("Stocks:"+older.getJSONObject(i).getString("stocks"));
				
				System.out.println("================================================");
				
			    
			     System.out.println("Enter the existing fileName To print stock report of Adding to shares!!");
  				 String fileName1=InputUtility.next();
  				JSONObject mainobj1 = file.ReadJsonFile(fileName1, jobj);
			     
  				JSONArray older1 = mainobj1.getJSONArray("CreateAccount");
  				for (int j = 0; j < older1.length(); j++) {
  					
  				System.out.println("=================STOCK-REPORT AFTER ADDING SHARES=================");
  				System.out.println();
  					System.out.println("Name:  "+older1.getJSONObject(j).getString("name"));
  					System.out.println("Shares:"+older1.getJSONObject(j).getString("shares"));
  					System.out.println("symbol:"+older1.getJSONObject(j).getString("symbol"));
  					System.out.println("cash:  "+older1.getJSONObject(j).getString("cash"));
  					System.out.println("NumberofStocks:"+older1.getJSONObject(j).getString("n"));
  					System.out.println("Stocks:"+older1.getJSONObject(j).getString("stocks"));
  					
  					System.out.println("================================================");
  					
  					
  					
  					 System.out.println("Enter the existing fileName To print stock report of Subtracting from shares!!");
  	  				 String fileName2=InputUtility.next();
  	  				JSONObject mainobj2= file.ReadJsonFile(fileName2, jobj);
  					
  	  			JSONArray older2 = mainobj2.getJSONArray("CreateAccount");
  				for (int k = 0; k < older2.length(); k++) {
  					
  				System.out.println("=================STOCK-REPORT AFTER SUBTRACTING FROM SHARES=================");
  				System.out.println();
  					System.out.println("Name:  "+older2.getJSONObject(k).getString("name"));
  					System.out.println("Shares:"+older2.getJSONObject(k).getString("shares"));
  					System.out.println("symbol:"+older2.getJSONObject(k).getString("symbol"));
  					System.out.println("cash:  "+older2.getJSONObject(k).getString("cash"));
  					System.out.println("NumberofStocks:"+older2.getJSONObject(k).getString("n"));
  					System.out.println("Stocks:"+older2.getJSONObject(k).getString("stocks"));
  					
  					System.out.println("================================================");
  					}
  				}
			}
		}
		catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
		    e.printStackTrace();
		}
		
		
		
		

	}

}
