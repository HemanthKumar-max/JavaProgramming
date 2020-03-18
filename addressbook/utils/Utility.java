package com.bridgelabz.oops.addressbook.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import com.bridgelabz.oops.addressbook.repository.AddressBookService;
import com.bridgelabz.oops.addressbook.serviceprovider.AddressBookServiceProvider;
import com.bridgelabz.userdefinedexception.CustomizedException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utility {

	private static final String FILEPATH = "/home/bridgelabz/eclipse-workspace/ObjectOrientedProgramming/staticfile/";

	private static JSONObject jsonObject = new JSONObject();

	private static String fileName;

	/**
	 * private Constructor to make the utility class as a Singleton Class
	 */
	private Utility() {

	}

	/**
	 * static method to get an instance of the Json
	 * 
	 * @return
	 */
	public static JSONObject getJsonObject() {
		return jsonObject;
	}

	/**
	 * static method to get an instance of the Service proviser Object
	 * 
	 * @return
	 */
	public static AddressBookService getServiceObject() {
		return new AddressBookServiceProvider();
	}

	/**
	 * static method to set the fileName
	 * 
	 * @param file
	 */
	public static void setFileName(String file) {
		fileName = file;
	}

	/**
	 * static method to get the FileName
	 * 
	 * @return
	 */
	public static String getFileName() {

		return fileName;
	}

	private static File getFile(String fileName) throws CustomizedException {

		File file = new File(FILEPATH + fileName);
		if (!file.exists()) {
			throw new CustomizedException("AddressBook Not Exists,select AddressBook properly");
		}
		return file;
	}

	public static Gson getGsonObject() {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		builder.serializeNulls();
		return builder.create();
	}

	public static FileReader getReaderObject(String fileName) {
		FileReader reader = null;
		try {
			try {
				reader = new FileReader(getFile(fileName));
			} catch (CustomizedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return reader;
	}

	public static FileWriter getWriteObject(String fileName2) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(FILEPATH + fileName2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writer;
	}
}
