package com.bridgelabz.stockmanagement.repository;

import java.util.ArrayList;

import org.json.JSONObject;

import com.bridgelabz.stockmanagement.model.StockModel;

public interface StockManagementRepository 
{
public void addStockDetails(String fileName);

public ArrayList<StockModel> Stock();
public void getShareDetails(String fileName, JSONObject Jobj);
public void getSharePriceDetails(String fileName, JSONObject jobj);
public void getTotalShare(String fileName,JSONObject jobj);
public void getTotalPrice(String fileName,JSONObject jobj);




}
