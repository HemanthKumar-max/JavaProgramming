package com.bridgelabz.fellowship.JunitTesting;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:Write a static function ​toBinary that outputs the binary (base 2) representation ofthe decimal number typed as the input.
 * And Swap nibbles and find the new number
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.JunitTesting.utility.Utility;

public class TobinaryAndswapnibbles 
{
	static String x="";
	public static void main(String[] args) 
	{
		System.out.println("enter the number");
		int number=Inpututility.nextInt();
		String res=Utility.binary(number,x);
		System.out.println("the binary no is"+res);
		int res1=Utility.swapnibbles(number);
		System.out.println("the swapped nibbles number is"+res1);
	}


}

