package com.bridgelabz.stockmanagement.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.bridgelabz.stockmanagement.serviceprovider.StockManagement;

public class FileUtility 
{
	static final String path = "F:\\java\\Kentropy work accessment\\Bootstrap\\OopsProject\\Static Json\\";
	static StockManagement stockmanagement=new StockManagement();
	
	
	public void ReadJsonFile(String fileName, JSONObject jobj)
			throws FileNotFoundException, IOException, JSONException {
		System.out.println("==>>" + fileName);
		try (FileReader f = new FileReader(path+fileName)) {
			JSONTokener t = new JSONTokener(f);
			JSONObject mainobj = new JSONObject(t);
			JSONArray result = mainobj.getJSONArray("Stocks");
			System.out.println(result);
			stockmanagement.getShareDetails(fileName,mainobj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeToFile(String fileName, JSONObject jObj) throws IOException, JSONException {
		try (FileWriter file = new FileWriter(path+fileName)) {
			file.write(jObj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("successful");

	}
}

	
	
	
