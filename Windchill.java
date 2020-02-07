package com.bridgelabz.fellowship.Functional;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose: prints the wind chill.
 **/


import org.apache.log4j.Logger;

import com.bridgelabz.fellowship.Functional.utility.Utility;
/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.utility.LogUtility;


public class Windchill {
	public static void main(String[] args) {
		LogUtility.setLog("Windchill");
		System.out.println("enter the temperature");
		double t = Inpututility.nextDouble();
		System.out.println("enter the speed");
		double v = Inpututility.nextDouble();
	    WindchillException(t,v);
	}
	public static void WindchillException(double t,double v)
	{
		Logger log = LogUtility.getLog();
	try
	{
		
		if(t<50 && v>=3 && v<=120)
		{
			Utility.findwindchill(t, v);
		}
		else
		{
		while (t >= 50.0) {
			throw new CustomizedException("Please enter the value of T lesser than 50");
		}
	
		while (v >= 120 || v <= 3) {
			throw new CustomizedException("Please enter the value of V less than 120 and greater than 3");
		}
	}
	}
	catch(CustomizedException e)
	{
		log.error("this type of message should not appear"+e);
		e.printStackTrace();
	}
		
        
	}
}
