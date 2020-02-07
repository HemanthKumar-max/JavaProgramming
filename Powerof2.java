package com.bridgelabz.fellowship.basicCoreprograms;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:prints a table of the powers of 2 that are less than or equal to 2^N. 
 **/


import org.apache.log4j.Logger;

/**
 * Here import the utility package  to use the Utility class in a program.
 **/



import com.bridgelabz.fellowship.basicCoreprograms.Utility.Utility;
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.utility.LogUtility;


public class Powerof2
{
	public static void main(String[] args) 
	{
		LogUtility.setLog("Powerof2");
		Logger log=LogUtility.getLog();
		System.out.println("enter the  number ");
		int n=Inpututility.nextInt();
	    NumberGreaterOrLesserException(n);
	} 
	
	public static void NumberGreaterOrLesserException(int n) 
	{
		try
		{
	if(n>=0 && n<31)
		{
			Utility.powerof2(n);
		}
		else
		{
			throw new CustomizedException("Please enter the number greater 0 or less than 31");
			
		}
		}
		catch(CustomizedException e)
		{
			e.printStackTrace();
		}
	
}
}