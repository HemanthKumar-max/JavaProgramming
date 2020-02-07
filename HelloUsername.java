package com.bridgelabz.fellowship.basicCoreprograms;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:Print the String with User Name  2
 **/

import org.apache.log4j.Logger;

/**
 * Here import the utility package  to use the Utility class in a program.
 **/

import com.bridgelabz.fellowship.basicCoreprograms.Utility.Utility;
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.utility.LogUtility;

public class HelloUsername {
	public static void main(String[] args) {
		LogUtility.setLog("HelloUsername");
		
		System.out.println("enter the user name");
		String name = Inpututility.nextLine();
		
		Minimumchar(name);

		
	}

	public static void Minimumchar(String name) 
	{
		Logger log = LogUtility.getLog();
		try {
 
			if (name.length() > 2) {
				Utility.helloUser(name);
			} else {
				throw new CustomizedException("Please enter minimum of 3 characters!!");
			}
		} catch (CustomizedException e) {
			log.error("this type of message should not appear"+e);
			e.printStackTrace();
		}
	}
}
