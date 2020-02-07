package com.bridgelabz.fellowship.Functional;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose: find the roots of the equation a*x*x + b*x + c. Since the equation is x*x, hence there are 2 roots
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.Functional.utility.Utility;

public class QuadraticEquation 
{
	public static void main(String[] args) 
	{
		System.out.println("enter the value of A");
		int a=Inpututility.nextInt();
		System.out.println("enter the value of B");
		int b=Inpututility.nextInt();
		System.out.println("enter the value of C");
		int c=Inpututility.nextInt();
		int delta=b*b-4*a*c;
		Utility.quadraticEquation(delta, a, b, c);
	}
}
