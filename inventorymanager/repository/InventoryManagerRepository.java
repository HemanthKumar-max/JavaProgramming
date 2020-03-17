package com.bridgelabz.inventorymanager.repository;

import org.json.JSONObject;

public interface InventoryManagerRepository 
{
public void addItemDetails(String fileName);
public void getDetails(String fileName, JSONObject jobj);
public void getPriceAndWeight(String fileName, JSONObject jobj);

}
