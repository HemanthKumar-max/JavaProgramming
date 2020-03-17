package com.bridgelabz.fellowship.datastructures;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:.Write a program ​Calendar.java that takes the month and year as command-line arguments and prints the Calendar of the month. 
 * Store the Calendar in an 2D Array.
  
 **/

import org.apache.log4j.Logger;

/**
 * Here import the utility package  to use the Utility class in a program.
 **/

import com.bridgelabz.fellowship.InputUtility.InputUtility;
import com.bridgelabz.fellowship.InputUtility.LogUtility;
import com.bridgelabz.fellowship.datastructures.utility.DataStructures;

public class Calender2DArray 
{
public static void main(String[] args) 
{
		LogUtility.setLog("Calender2dArray");
		Logger log = LogUtility.getLog();
		System.out.println("enter month");
		int m = InputUtility.nextInt();
		System.out.println("enter year");
		int y = InputUtility.nextInt();
		log.info("Display of calender using 2darray");
		DataStructures.dispCalender(m, y);
		
		
		
	}	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
  
  
  
  
  

 