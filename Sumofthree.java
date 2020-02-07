package com.bridgelabz.fellowship.Functional;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose: A program with cubic running time. Read in N integers and counts the number of triples that sum to exactly 0.
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.Functional.utility.Utility;

public class Sumofthree 
{
	public static void main(String[] args) 
	{
		System.out.println("enter the size");
		int size=Inpututility.nextInt();
		int[] arr=new int[size];
		System.out.println("enter the integers");
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=Inpututility.nextInt();
		}
		Utility.Sumofthree(arr,size);
	}
}
