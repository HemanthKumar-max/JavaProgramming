package com.bridgelabz.fellowship.Algorithm;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:Extend the above program to find the prime numbers that are Palindrome.
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

public class PrimePalindrome 
{
	
public static void main(String[] args) 
{
	LogUtility.setLog("PrimeAnagram");
	Logger logger=LogUtility.getLog();			
	logger.info("enter the range1");
	System.out.println("enter the range 1 ");
	int m=Inpututility.nextInt();
	logger.info("enter the range 2");
	System.out.println("enter the range 2");
	int n=Inpututility.nextInt();
	Utility.primePalindrome(m,n);	
}
}
