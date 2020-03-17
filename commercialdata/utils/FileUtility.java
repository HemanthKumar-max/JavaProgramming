package com.bridgelabz.commercialdata.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.bridgelabz.commercialdata.serviceprovider.StockAccount;

public class FileUtility 
{
	static final String path = "F:\\java\\Kentropy work accessment\\Bootstrap\\OopsProject\\Static Json\\";
	 static StockAccount stockaccount=new  StockAccount();
	public JSONObject ReadJsonFile(String fileName, JSONObject jobj)
			throws FileNotFoundException, IOException, JSONException {
		System.out.println("==>>" + fileName);
		try (FileReader f = new FileReader(path+fileName)) {
			JSONTokener t = new JSONTokener(f);
			JSONObject mainobj = new JSONObject(t);
			JSONArray result = mainobj.getJSONArray("CreateAccount");
			System.out.println(result);
			return mainobj;	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobj;
		
	}

	public void writeToFile(String fileName, JSONObject jObj) throws IOException, JSONException {
		try (FileWriter file = new FileWriter(path+fileName)) {
			file.write(jObj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("successful");

	}
	public void writeToFileString(String fileName,String name) throws IOException, JSONException {
		try (FileWriter file = new FileWriter(path+fileName)) {
			file.write(name.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("successful");

	}
	
	
	
	
	
	
}
