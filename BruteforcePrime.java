package com.bridgelabz.fellowship.basicCoreprograms;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:Print the prime factors of number N. 
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/



import com.bridgelabz.fellowship.basicCoreprograms.Utility.Utility;
import com.bridgelabz.fellowship.utility.Inpututility;

public class BruteforcePrime        
{
	public static void main(String[] args) 
	{
		System.out.println("enter the  number");
		int res=Inpututility.nextInt();
		Utility.primefactors(res);
	}
}
