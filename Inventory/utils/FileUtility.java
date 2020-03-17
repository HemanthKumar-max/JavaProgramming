package com.bridgelabz.Inventory.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.bridgelabz.Inventory.serviceprovider.InventoryItemService;
import com.bridgelabz.inventorymanager.serviceprovider.InventoryManager;

public class FileUtility {
	static final String path = "F:\\java\\Kentropy work accessment\\Bootstrap\\OopsProject\\Static Json\\";
	static InventoryItemService inventorycont = new InventoryItemService();
	public JSONObject ReadJsonFile(String fileName)
			throws FileNotFoundException, IOException, JSONException {
		System.out.println("==>>" + fileName);
		try (FileReader f = new FileReader(path+fileName)) {
			JSONTokener t = new JSONTokener(f);
			JSONObject mainobj = new JSONObject(t);
			JSONArray result = mainobj.getJSONArray("InventoryItems");
			System.out.println(result);
			inventorycont.getDetails(fileName, mainobj);
			return mainobj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
