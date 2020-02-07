package com.bridgelabz.fellowship.basicCoreprograms;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:> Print the year is a Leap Year or not. 
 **/


import org.apache.log4j.Logger;

/**
 * Here import the utility package  to use the Utility class in a program.
 **/



import com.bridgelabz.fellowship.basicCoreprograms.Utility.Utility;

import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.utility.LogUtility;


public class LeapYear 
{
	public static void main(String[] args) 
	{
		LogUtility.setLog("LeapYear");
		
		System.out.println("enter the  year");
		int year=Inpututility.nextInt();
		
			YearGreaterthanFourdigits(year);
		
		
		
		
	}
		public static void YearGreaterthanFourdigits(int year) 
		{
			Logger log=LogUtility.getLog();
			try
			{
		if(year>=1000  && year<=9999)
		{
			Utility.leapyear(year);
		}
		else
		{
			throw new CustomizedException("Please enter the Correct Year format");
		}
			}
			catch(CustomizedException e)
			{
				log.error("this type of message should not appear"+e);
				e.printStackTrace();
			}


	}
}

