package com.bridgelabz.fellowship.basicCoreprograms;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose: Flip Coin and print percentage of Heads and Tails.
 *
 **/

import org.apache.log4j.Logger;

/**
 * Here import the utility package  to use the Utility class in a program.
 **/

import com.bridgelabz.fellowship.basicCoreprograms.Utility.Utility;
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.utility.LogUtility;

public class Flipcoin {
	public static void main(String[] args)  {
		LogUtility.setLog("Flipcoin");
		System.out.println("enter the no of times that coin to be flipped");
		int n = Inpututility.nextInt();

		
			numbergreater(n);
		} 
		


	public static void numbergreater(int n) 
	{
		Logger log = LogUtility.getLog();
	try
	{
		if (n > 0) {
	
			String res = Utility.flipcoin(n);
			System.out.println(res + "%");

		}
		while (n == 0 || n < 0) {

			throw new CustomizedException("Please enter the Number > 0");

		}
		String res = Utility.flipcoin(n);
		System.out.println(res + "%");

	}
	catch(CustomizedException e)
	{
		log.error("this type of message should not appear"+e);
		e.printStackTrace();
	}
}
}