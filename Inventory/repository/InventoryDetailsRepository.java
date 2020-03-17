package com.bridgelabz.Inventory.repository;

import org.json.JSONObject;

public interface InventoryDetailsRepository {

	public void getDetails(String fileName, JSONObject jobj);

	public void getPriceAndWeight(String fileName, JSONObject jobj);

	public void addItemDetails(String fileName);

	

}
