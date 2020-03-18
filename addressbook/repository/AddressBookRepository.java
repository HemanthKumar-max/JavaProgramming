package com.bridgelabz.oops.addressbook.repository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.oops.addressbook.utils.Utility;
import com.bridgelabz.userdefinedexception.CustomizedException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class AddressBookRepository {

	Gson gson = Utility.getGsonObject();

	String personDetails;

	private static AddressBookRepository repo = null;
	
	private AddressBookRepository() {
		
	}
	public static AddressBookRepository getInstance() {
		if(repo == null)
			repo = new AddressBookRepository();
		return repo;
	}
	public void writeJson(JSONArray personDetails, String fileName){

		try (FileWriter writer = Utility.getWriteObject(fileName)) {
			gson.toJson(personDetails, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String readJson(String fileName) throws CustomizedException {

		
		try (FileReader fileReader = Utility.getReaderObject(fileName)) {
		 JsonArray array = gson.fromJson(fileReader, JsonArray.class);
		 personDetails = gson.toJson(array);
		 
		} catch (IOException e) {
			e.printStackTrace();
		}

		return personDetails;
	}

}
