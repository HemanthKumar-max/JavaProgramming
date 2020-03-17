package com.bridgelabz.companyshares.serviceprovider;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.bridgelabz.Inventory.utils.InputUtility;
import com.bridgelabz.companyshares.controller.Runner;
import com.bridgelabz.companyshares.model.CompanyDateTimeModel;
import com.bridgelabz.companyshares.model.CompanyShareModel;
import com.bridgelabz.companyshares.model.CompanySymbolModel;
import com.bridgelabz.companyshares.model.LinkedList;
import com.bridgelabz.companyshares.model.Queue;
import com.bridgelabz.companyshares.model.StackLinkedList;
import com.bridgelabz.companyshares.repository.CompanyShareRepository;
import com.bridgelabz.companyshares.utils.FileUtility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CompanyShareService implements CompanyShareRepository {

	static LinkedList al = new LinkedList();
	static StackLinkedList alstack = new StackLinkedList();
	static FileUtility file = new FileUtility();
	static Runner runner = new Runner();
	static CompanyShareModel comshare = new CompanyShareModel();
	static Queue alque = new Queue();

	@Override
	/**
	 * An instance method addcompanydetails(),to add the values of company name,shares and converting the object into json file.
	 */
	public void addCompanyDetails(String fileName) {
		try {
			System.out.println("enter the number 1 to add shares or 0 to quit");
			int res = InputUtility.nextInt();
			while (res != 0) {
				System.out.println("enter the company name");
				String name = InputUtility.next();
				System.out.println("enter the company shares");
				int shares = InputUtility.nextInt();
				CompanyShareModel comModel = new CompanyShareModel(name, shares);
				al.push(comModel.getShares());
				al.push(comModel.getCompanyName());
				System.out.println("enter the number 1 to add shares or 0 to quit");
				res = InputUtility.nextInt();
				if (res == 0) {
					GsonBuilder gsonBuilder = new GsonBuilder();
					Gson gson = gsonBuilder.create();
					String response = gson.toJson(al);
					System.out.println(response);
					file.writeToFileString(fileName, response);
					runner.interpreter(fileName, al);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * An instance method removecompanydetails(),to remove the values of shares and converting the object into json file.
	 */
	public void removeCompanyShares(String fileName, LinkedList al12) {
		try {

			System.out.println("enter the share that you want to delete");
			int res = InputUtility.nextInt();
			al12.deleteNode(res);
			System.out.println("share has been deleted!!");
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String response = gson.toJson(al12);
			System.out.println(response);
			file.writeToFileString(fileName, response);
			runner.interpreter(fileName, al12);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@Override
/**
 * An instance method displayinfo(),to display the values of company name,shares .
 */
	public void displayInfo(String fileName) {
		try {
			JSONObject jmain = file.ReadJsonFileString(fileName);
			System.out.println("-->" + jmain);
			String jmain1 = jmain.getJSONObject("head").getJSONObject("next").getJSONObject("next")
					.getJSONObject("next").getString("data");
			JSONObject data = jmain.getJSONObject("head").getJSONObject("next").getJSONObject("next")
					.getJSONObject("next").getJSONObject("next");
			String jmain2 = jmain.getJSONObject("head").getJSONObject("next").getString("data");
			System.out.println(jmain2);
			String jmain3 = jmain.getJSONObject("head").getJSONObject("next").getJSONObject("next").getString("data");
			System.out.println(jmain3);
			System.out.println("===========Details======");
			System.out.println("company name:" + jmain1);
			System.out.println("company shares:" + data.getString("data"));
			System.out.println("--------------------------");
			System.out.println("company name:" + jmain2);
			System.out.println("company shares:" + jmain3);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@Override
	/***
	 * An instance method stocksymbolpurchased(),to add the extra company symbols to stockaccount 
	 */
	public void stockSymbolPurchased(String fileName) {
		try {
			System.out.println("enter the Buyer");
			String buy = InputUtility.next();
			System.out.println("enter the seller");
			String seller = InputUtility.next();
			System.out.println("enter the  company symbol");
			String symbol = InputUtility.next();
			CompanySymbolModel comsym = new CompanySymbolModel(buy, seller, symbol);
			alstack.push(comsym.getBuyer());
			alstack.push(comsym.getSymbol());
			alstack.push(comsym.getSeller());
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String response = gson.toJson(alstack);
			System.out.println(response);
			System.out.println("stock symbol has been purchased!!");
			file.writeToFileString(fileName, response);
			runner.interpreterSymbol(fileName, alstack);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@Override
	/**
	 * An instance method stocksymbolSold(),to remove the extra company symbols from stockaccount 
	 */
	public void stockSymbolSold(String fileName) {
		try {
			System.out.println("enter the symbol that you want to sell");
			String res = InputUtility.next();
			alstack.peek();
			System.out.println("-->" + alstack);
			alstack.pop();
			System.out.println("stock symbol has been sold!!");
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String response = gson.toJson(alstack);
			System.out.println(response);
			file.writeToFileString(fileName, response);
			runner.interpreterSymbol(fileName, alstack);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * An instance method addCompanydateTime(),to add the date and time to the stockaccount. 
	 */
	public void addCompanyDateTimeDetails(String fileName) {
		try {
		System.out.println("enter the  date of Buyer");
		int date=InputUtility.nextInt();
		System.out.println("enter the time of buyer");
		int time=InputUtility.nextInt();
		System.out.println("enter the transaction amount");
		int amount=InputUtility.nextInt();
		CompanyDateTimeModel comDateTime=new CompanyDateTimeModel(date,time,amount);
		alque.enqueue(date);
		alque.enqueue(time);
		alque.enqueue(amount);
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		String response = gson.toJson(alque);
		System.out.println(response);
		file.writeToFileString(fileName, response);
		runner.companySharesMenu();
	}
		catch (IOException e) {
		    e.printStackTrace();
		} catch (JSONException e) {
	        e.printStackTrace();
		}
	}
}