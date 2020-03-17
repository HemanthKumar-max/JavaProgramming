package com.bridgelabz.companyshares.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class FileUtility {
	static final String path = "F:\\java\\Kentropy work accessment\\Bootstrap\\OopsProject\\Static Json\\";
	
	
	
	public JSONObject ReadJsonFile(String fileName, JSONObject jobj)
			throws FileNotFoundException, IOException, JSONException {
		System.out.println("==>>" + fileName);
		try (FileReader f = new FileReader(path+fileName)) {
			JSONTokener t = new JSONTokener(f);
			JSONObject mainobj = new JSONObject(t);
			JSONArray result = mainobj.getJSONArray("");
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
		
		
		
		public JSONObject ReadJsonFileString(String fileName)
				throws FileNotFoundException, IOException, JSONException {
			System.out.println("==>>" + fileName);
			try (FileReader f = new FileReader(path+fileName)) {
				JSONTokener t = new JSONTokener(f);
				JSONObject mainobj = new JSONObject(t);
				JSONObject result = mainobj.getJSONObject("head");
				System.out.println(result);
				return mainobj;	
				} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
			

	}	
	
	
	
	
	
	
}
