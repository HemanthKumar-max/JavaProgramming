package com.bridgelabz.fellowship.datastructures;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:A palindrome is a string that reads the same forward and backward, for example, radar, toot, and madam. We would like to construct an algorithm to input a string of characters and check whether it is a palindrome. 
 **/
/**
 * Here import the utility package to use the Utility class in a program.
 **/

import com.bridgelabz.fellowship.InputUtility.InputUtility;
/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.datastructures.utility.DataStructures;

public class Palindromechecker 
{
	public static void main(String[] args) {
		System.out.println("Enter a String: ");
		String s =InputUtility.nextLine();
		
		DataStructures.displayPalindromeChecker(s);
	}
	
		
		
		
		
		
	}

