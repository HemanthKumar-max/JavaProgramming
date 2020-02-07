package com.bridgelabz.fellowship.Algorithm;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose: Extend the above program to find the prime numbers that are Anagram.
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

public class PrimeAnagram 
{

	public static void main(String[] args) 
	{ 

		LogUtility.setLog("PrimeAnagram");
		Logger logger=LogUtility.getLog();		
		logger.info("enter the range of numbers from low to high");
		System.out.println("please enter the range  of numbers from low to high");
		System.out.println("enter the range1  ");
		int m=Inpututility.nextInt();
		System.out.println("enter the range2");
		int n=Inpututility.nextInt();
		Utility.prime(m,n);
		Utility.primeAnagrams(m,n);
		
}
}
