package com.bridgelabz.fellowship.Functional;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose: A library for reading in 2D arrays of integers, doubles, or booleans from standard input and printing them out to standard output. 
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.Functional.utility.Utility;

public class TwodArray
{
	public static void main(String[] args)  
	{
		System.out.println("enter the size of first array");
		int m=Inpututility.nextInt();
		System.out.println("enter the  size of second array");
		int n=Inpututility.nextInt();
		double[][] a=new double[m][n];
		System.out.println("enter the numbers");
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<n;j++)
			{
				a[i][j]=Inpututility.nextDouble();
			}
		}

		Utility.print2DArray(a);

	}
}

