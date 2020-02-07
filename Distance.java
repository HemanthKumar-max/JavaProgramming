package com.bridgelabz.fellowship.Functional;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:Write a program that prints the Euclidean distance from the point (x, y) to the origin.
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.Functional.utility.Utility;
import com.bridgelabz.fellowship.utility.Inpututility;


public class Distance 
{
	public static void main(String[] args) 
	{
		System.out.println("enter the value of x");
		int x=Inpututility.nextInt();
		System.out.println("enter the value of x");
		int y=Inpututility.nextInt();
		double res=Utility.distance(x, y);
		System.out.println("the distance is"+res);
	}
}
