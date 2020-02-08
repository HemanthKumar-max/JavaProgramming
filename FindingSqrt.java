package com.bridgelabz.fellowship.JunitTesting;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose: Write a static function ​sqrt to compute the square root of a nonnegative number c  given in the input using Newton's method
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.JunitTesting.utility.Utility;

public class FindingSqrt 
{
	public static void main(String[] args) 
	{
		System.out.println("enter the number");
		int number=Inpututility.nextInt();
		int res=Utility.sqrt(number);
		System.out.println("the sqrt of number is"+res);
	}
}
