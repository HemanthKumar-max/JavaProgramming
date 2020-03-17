package com.bridgelabz.stockmanagement.serviceprovider;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.bridgelabz.inventorymanager.utils.InputUtility;
import com.bridgelabz.stockmanagement.controller.Runner;
import com.bridgelabz.stockmanagement.model.StockManagementModel;
import com.bridgelabz.stockmanagement.model.StockModel;
import com.bridgelabz.stockmanagement.repository.StockManagementRepository;
import com.bridgelabz.stockmanagement.utils.FileUtility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class StockManagement implements StockManagementRepository {
	static Runner runner = new Runner();
	static JSONArray jsonarray = new JSONArray();
	static JSONObject jobj = new JSONObject();
	static StockManagement stockmanagement = new StockManagement();
	static ArrayList<StockManagementModel> stockmanagemod = new ArrayList<>();
	static ArrayList<StockModel> stockmod = new ArrayList<>();
	static FileUtility file = new FileUtility();
	static double totalShare = 0.0;
	static double totalSharePrice = 0.0;

	@Override
	/**
	 * An instance method  addStockdetails(),used to add details of company and convert the object into json file
	 */
	public void addStockDetails(String fileName) {
		try {
			System.out.println("enter the name of the company");
			String companyName = InputUtility.next();
			System.out.println("enter the industry");// material,financial,information tecjnology
			String industry = InputUtility.next();
			System.out.println("enter the  number of stocks");
			int stocks = InputUtility.nextInt();
			StockManagementModel stockmanage = new StockManagementModel(companyName, stocks, industry);
			stockmanagemod.add(stockmanage);
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String response = gson.toJson(stockmanagemod);
			System.out.println(response);
			for (int i = 1; i <= stocks; i++) {
				System.out.println("stock:" + i);
				ArrayList<StockModel> al = stockmanagement.Stock();
				String response1 = gson.toJson(al);
				System.out.println(response1);
				jobj.put("Stocks", response1);
				jobj.put("stockManagement", response);
				System.out.println(jobj);
				file.writeToFile(fileName, jobj);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * An instance method getshareDetails(),used to get the info of shareDetails
	 */
	public void getShareDetails(String fileName, JSONObject jobj) {
		try {
			JSONArray result = jobj.getJSONArray("Stocks");
			for (int i = 0; i < result.length(); i++) {
				System.out.println("=============ShareDetails==================");
				System.out.println("stockName     :" + result.getJSONObject(0).getString("stockName"));
				System.out.println("NumberofShares:" + result.getJSONObject(0).getString("numberOfShare"));
				System.out.println("============================================");
				System.out.println("stockName     :" + result.getJSONObject(1).getString("stockName"));
				System.out.println("NumberofShares:" + result.getJSONObject(1).getString("numberOfShare"));
				System.out.println("=============================================");
				runner.stockManagementMenu(fileName, jobj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * An instance method getSharePrice() ,used to get total share and price 
	 */
	public void getSharePriceDetails(String fileName, JSONObject jobj) {
		try {
			JSONArray result = jobj.getJSONArray("Stocks");
			for (int i = 0; i < result.length(); i++) {
				System.out.println("=============SharePriceDetails==================");
				System.out.println("stockName     :" + result.getJSONObject(0).getString("stockName"));
				System.out.println("SharePrice:" + result.getJSONObject(0).getString("sharePrice"));
				System.out.println("============================================");
				System.out.println("stockName     :" + result.getJSONObject(1).getString("stockName"));
				System.out.println("sharePrice:" + result.getJSONObject(1).getString("sharePrice"));
				System.out.println("=============================================");
				runner.stockManagementMenu(fileName, jobj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<StockModel> Stock() {
		System.out.println("enter the Name of a stock");
		String stockName = InputUtility.next();
		System.out.println("Enter the number of share");
		int share = InputUtility.nextInt();
		System.out.println("enter the share price");
		int shareprice = InputUtility.nextInt();
		StockModel stock = new StockModel(stockName, share, shareprice);
		stockmod.add(stock);
		return stockmod;

	}

	@Override
	public void getTotalShare(String fileName, JSONObject jobj) {
		try {

			JSONArray result = jobj.getJSONArray("Stocks");
			for (int i = 0; i < result.length(); i++) {
				System.out.println("=============TotalShare==================");

				System.out.println("NumberofShares-->For:" + result.getJSONObject(0).getString("stockName") + "is "
						+ result.getJSONObject(0).getString("numberOfShare"));
				System.out.println("NumberofShares-->For:" + result.getJSONObject(1).getString("stockName") + "is "
						+ result.getJSONObject(1).getString("numberOfShare"));
				double numberOfShare = Integer.parseInt(result.getJSONObject(0).getString("numberOfShare"));
				double numberOfShare1 = Integer.parseInt(result.getJSONObject(1).getString("numberOfShare"));
				System.out.println("===========================================");
				totalShare = numberOfShare + numberOfShare1;
				System.out.println("Total numberofShare:" + totalShare);
				System.out.println("============================================");
				runner.stockManagementMenu(fileName, jobj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getTotalPrice(String fileName, JSONObject jobj) {
       try {
	    JSONArray result = jobj.getJSONArray("Stocks");
        for(int i = 0; i < result.length();i++) {
		System.out.println("=============TotalSharePrice==================");
		
		System.out.println("SharePrice-->For:"+ result.getJSONObject(0).getString("stockName")+"is "+result.getJSONObject(0).getString("sharePrice"));
		System.out.println("SharePrice-->For:"+ result.getJSONObject(1).getString("stockName")+"is "+ result.getJSONObject(1).getString("sharePrice"));
		double sharePrice = Integer.parseInt(result.getJSONObject(0).getString("sharePrice"));
		double sharePrice1 = Integer.parseInt(result.getJSONObject(1).getString("sharePrice"));
		System.out.println("===========================================");
		totalSharePrice=sharePrice+sharePrice1;
		System.out.println("Total sharePrice:"+totalSharePrice);
		System.out.println("============================================");
		runner.stockManagementMenu(fileName, jobj);
			}
        
     }
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
