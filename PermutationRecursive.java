package com.bridgelabz.fellowship.Algorithm;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:Write static functions to return all permutations of a String using Recursive method.
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/

import com.bridgelabz.fellowship.Algorithms.Utility.Utility;
import com.bridgelabz.fellowship.utility.Inpututility;

public class PermutationRecursive 
{
	public static void main(String[] args) 
	{
	System.out.println("enter the String to get permutation");
	String s=Inpututility.next();	
	Utility.permutationsRecursive(s.toCharArray(), 0);

	}	
}

