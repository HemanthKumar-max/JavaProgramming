package com.bridgelabz.fellowship.JunitTesting;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose: To the Util Class add ​dayOfWeek static function that takes a date as input and prints the day of the week that date falls on.
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.JunitTesting.utility.Utility;
import com.bridgelabz.fellowship.utility.Inpututility;


public class Dayofweek 
{
	public static void main(String[] args) 
	{

		System.out.println("enter the month");            
		int m=Inpututility.nextInt();
		System.out.println("enter the date");
		int d=Inpututility.nextInt();
		System.out.println("enter the year");
		int y=Inpututility.nextInt();
		int res=Utility.dayofweek(m, d, y);
		System.out.println(res);
	}
}
