package com.bridgelabz.inventorymanager.serviceprovider;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.bridgelabz.inventorymanager.controller.Runner;
import com.bridgelabz.inventorymanager.model.InventoryFactory;
import com.bridgelabz.inventorymanager.repository.InventoryManagerRepository;
import com.bridgelabz.inventorymanager.utils.FileUtility;
import com.bridgelabz.inventorymanager.utils.InputUtility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class InventoryManager implements InventoryManagerRepository 
{
	static final String path = "F:\\java\\Kentropy work accessment\\Bootstrap\\OopsProject\\Static Json\\";
   static JSONObject jobj=new JSONObject();
  static JSONArray jsonarray=new JSONArray();
   static ArrayList<InventoryFactory> al=new ArrayList<>();
   static FileUtility  file =new FileUtility(); 
   static InventoryFactory ifact=new InventoryFactory();
	static Runner runner = new Runner();
   
	@Override
	/**
	 * An instance method additemDetails(),to add the details of inventorymanager and convert the object into json file
	 */
	public void addItemDetails(String fileName) {
		try {
			System.out.println("enter the brandName");
			String name = InputUtility.next();
			System.out.println("enter the costprice");
			int cost = InputUtility.nextInt();
			System.out.println("enter the netweight");
			int price = InputUtility.nextInt();
			InventoryFactory ifact = new InventoryFactory(name, cost, price);
			al.add(ifact);
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String s = gson.toJson(al);
			System.out.println(s);
			jsonarray.put(s);
			jobj.put("InventoryManager", jsonarray);
			System.out.println(jobj);
			System.out.println("============DetailsAdded============");
			System.out.println("brandName:" + ifact.getBrandName());
			System.out.println("costPrice:" + ifact.getCostPrice());
			System.out.println("netWeight:" + ifact.getNetWeight());
			System.out.println("===================================");
			file.writeToFile(fileName, jobj);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	/***
	 * An instance method getdetails(),used to get the details of each element  of inventory manager
	 */
	public void getDetails(String fileName, JSONObject jobj) {
		try {

			JSONArray result = jobj.getJSONArray("InventoryManager");
			System.out.println("the result is" + result);
			for (int i = 0; i < result.length(); i++) {
				System.out.println("=============Details==================");
				System.out.println("costPrice :" + result.getJSONObject(i).getString("costPrice") + "Rs");
				System.out.println("brandName  :" + result.getJSONObject(i).getString("brandName") + "(type)");
				System.out.println("netWeight:" + result.getJSONObject(i).getString("netWeight") + "KG");
				runner.inventoryManagerDetails(fileName, jobj);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	@Override
	/**
	 * An instance method getpriceAndweight(),used to get the total value of priceandweight of inventory Manager
	 */
	public void getPriceAndWeight(String fileName, JSONObject jobj) {
		try (FileReader f = new FileReader(path + fileName)) {
			JSONTokener t = new JSONTokener(f);
			JSONObject mainobj = new JSONObject(t);
			JSONArray result = mainobj.getJSONArray("InventoryManager");
			double totalprice = 0.0;
			double totalweight = 0.0;
			for (int i = 0; i < result.length(); i++) {
				System.out.println("=============GetPrice==================");
				System.out.println("weight entered :" + result.getJSONObject(i).getString("netWeight") + "KG");
				double weight = Double.parseDouble(result.getJSONObject(i).getString("netWeight"));
				ifact.setCostPrice(50);
				totalprice = ifact.getCostPrice() * weight;// assume 1kg(rice)=50.0;
				System.out.println(
						"total price:" + totalprice + "Rs   for" + weight + "KG  of respective inventory  item");
				System.out.println("=========================================");
				System.out.println("=================GetWeight==============");
				System.out.println("price entered :" + result.getJSONObject(i).getString("costPrice") + "Rs");
				double price = Double.parseDouble(result.getJSONObject(i).getString("costPrice"));
				ifact.setNetWeight(1000);
				totalweight = (price / ifact.getNetWeight()) * 100;
				System.out.println(
						"total weight:" + totalweight + "KG   for" + price + "Rs  of respective inventory item");
				System.out.println("=======================================================");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
		
		
	
