package com.bridgelabz.fellowship.JunitTesting;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose: To the Util Class add​temperaturConversionstatic function, given the temperature in fahrenheit as input outputs the temperature in Celsius or viceversa using theformula 
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.JunitTesting.utility.Utility;

public class TemperatureConversion 
{
	public static void main(String[] args) 
	{

		System.out.println("enter the  temperature");
		int n=Inpututility.nextInt();
		System.out.println("enter the celcius");
		int m=Inpututility.nextInt();
		double t=Utility.temperature(n);
		double c=Utility.celsius(m);
		System.out.println("the temperature is"+t);     
		System.out.println("the celcius is "+c);          
	}			
}			                                                     





