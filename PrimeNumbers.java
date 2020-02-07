package com.bridgelabz.fellowship.Algorithm;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:To print the prime numbers of the given range.
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/


import org.apache.log4j.Logger;

/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.Algorithms.Utility.Utility;
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.utility.LogUtility;

public class PrimeNumbers 
{
	
public static void main(String[] args) 
{

	LogUtility.setLog("PrimeNumbers");
	Logger logger=LogUtility.getLog();
	logger.info("enter the low range");
System.out.println("enter the low range to print prime numbers");	
int low=Inpututility.nextInt();
logger.info("enter the high range");
System.out.println("enter the high range to print prime numbers");	
int high=Inpututility.nextInt();
Utility.primeNumbers(low,high);



}
}
