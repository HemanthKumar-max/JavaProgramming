package com.bridgelabz.Inventory.serviceprovider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.bridgelabz.Inventory.controller.Runner;
import com.bridgelabz.Inventory.model.Item;
import com.bridgelabz.Inventory.repository.InventoryDetailsRepository;
import com.bridgelabz.Inventory.utils.FileUtility;
import com.bridgelabz.Inventory.utils.InputUtility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class InventoryItemService implements InventoryDetailsRepository {
	static Item item = new Item();
	static Runner itemview = new Runner();
	static JSONArray jsonarray = new JSONArray();
	static JSONObject jobj = new JSONObject();
	static ArrayList<Item> itemal = new ArrayList<>();
	static Runner runner = new Runner();
	FileUtility file = new FileUtility();
	

	@Override
	/**
	 * An instance method getDetails(),is used to getdetails of price,name,weight
	 */
	public void getDetails(String fileName, JSONObject mainobj) {
		try {
			JSONArray result = mainobj.getJSONArray("InventoryItems");
			System.out.println("the result is" + result);
			for (int i = 0; i < result.length(); i++) {
				System.out.println("=============Details==================");
				System.out.println("Price :" + result.getJSONObject(i).getString("price") + "Rs");
				System.out.println("Name  :" + result.getJSONObject(i).getString("name") + "(type)");
				System.out.println("Weight:" + result.getJSONObject(i).getString("weight") + "KG");
				runner.inventoryDetails(fileName, mainobj);
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
	/**
	 * An instance method used to additem details and convert the object into json file..
	 */
	public void addItemDetails(String fileName) {
		try {
			System.out.println("Please enter the Details below!!");
			System.out.println("================================");
			System.out.println("enter the name of the type(Rice/wheat/pulses) :");
			String name = InputUtility.next();
			System.out.println("enter the weight:(1kg --->1000grams)");
			int weight = InputUtility.nextInt();
			System.out.println("enter the price:(50Rs----->1kg)");
			int price = InputUtility.nextInt();
			Item item = new Item(name, weight, price);
			itemal.add(item);
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String response = gson.toJson(itemal);
			System.out.println(response);
			jsonarray.put(response);
			jobj.put("InventoryItems", jsonarray);
			System.out.println(jobj);
			System.out.println("========details added=====");
			System.out.println("Name: " + item.getName());
			System.out.println("weight:" + item.getWeight());
			System.out.println("price :" + item.getPrice() + "(50 Rupees/KG)");
			System.out.println("============================");
			file.writeToFile(fileName, jobj);
			System.out.println("file has been writtened!");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * An instance method getpriceandweight(),used to get the total value of price and weight
	 */
	public void getPriceAndWeight(String fileName, JSONObject jobj) {
		try
		{
	          JSONObject mainobj= file.ReadJsonFile(fileName);
			JSONArray result = mainobj.getJSONArray("InventoryItems");
			double totalprice = 0.0;
			double totalweight = 0.0;
			for (int i = 0; i < result.length(); i++) {
				System.out.println("=============GetPrice==================");
				System.out.println("weight entered :" + result.getJSONObject(i).getString("weight") + "KG");
				double weight = Double.parseDouble(result.getJSONObject(i).getString("weight"));
				item.setPrice(50);
                totalprice = item.getPrice() * weight;// assume 1kg(rice)=50.0;
				System.out.println(
						"total price:" + totalprice + "Rs   for" + weight + "KG  of respective inventory  item");
				System.out.println("=========================================");
				System.out.println("=================GetWeight==============");
				System.out.println("price entered :" + result.getJSONObject(i).getString("price") + "Rs");
				double price = Double.parseDouble(result.getJSONObject(i).getString("price"));
				item.setWeight(1000);
				totalweight = (price / item.getWeight()) * 100;
				System.out.println(
						"total weight:" + totalweight + "KG   for" + price + "Rs  of respective inventory item");
				System.out.println("=======================================================");
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