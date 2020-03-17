package com.bridgelabz.fellowship.datastructures;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:
 * 
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/

import org.apache.log4j.Logger;
import com.bridgelabz.fellowship.InputUtility.InputUtility;
import com.bridgelabz.fellowship.InputUtility.LogUtility;
import com.bridgelabz.fellowship.datastructures.utility.DataStructures;

public class CalenderQueue 
{
	public static void main(String[] args) {
		LogUtility.setLog("Calender queue");
		Logger log=LogUtility.getLog();			
		int year, month;
		boolean isLeapYear;
		int days;
		int day;
		int[] daysPerYear = { 31, 28, 30, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		System.out.println("Enter month");
		month = InputUtility.nextInt();
		log.warn("Please enter the month greater than 0 and lesser or equal to 12");
		if (month > 0 && month <= 12) {
			System.out.println("Enter year");
			year = InputUtility.nextInt();
			if (year > 1582 && year < 9999) {
				isLeapYear = DataStructures.isLeapYear(year);
				log.info("Checking for leap year");
				if (isLeapYear && month == 2) {
					days = 29;
					day = DataStructures.dayOfWeek(month, year);
					DataStructures.printCalendarUsingQueue(day, days);
                }
				else 
				{
					days = daysPerYear[month - 1];
					day = DataStructures.dayOfWeek(month, year);
					log.info("checking for day of week");
					DataStructures.printCalendarUsingQueue(day, days);
				}
			}
			else
				System.out.println("please enter valid year");
			    log.info("year is valid year");
		} 
		else
			System.out.println("Please enter valid month");
             log.info("year is not valid ");
         }
}
