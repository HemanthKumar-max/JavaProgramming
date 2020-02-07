package com.bridgelabz.fellowship.basicCoreprograms;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose: Prints the Nth harmonic number: 1/1 + 1/2 + ... + 1/N 
 **/


import org.apache.log4j.Logger;

/**
 * Here import the utility package  to use the Utility class in a program.
 **/



import com.bridgelabz.fellowship.basicCoreprograms.Utility.Utility;
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.utility.LogUtility;


public class harmonicNumber 
{
	public static void main(String[] args) 
	{
		LogUtility.setLog("harmonicNumber");
		
		System.out.println("enter the number");
		int n=Inpututility.nextInt();
		numberEqualToZero(n);
	}
	
	
		public static void numberEqualToZero(int n)
		{
			Logger log=LogUtility.getLog();
		try
		{
		if(n==0)
		{
			throw new CustomizedException("Please enter number greater than 0");
		}
		else
		{
		float res=Utility.harmonic(n);
		System.out.println(res);
	    }
		}
		catch(CustomizedException e)
		{
			log.error("this type of message should not appear"+e);
           e.printStackTrace();			
		}


		}
}