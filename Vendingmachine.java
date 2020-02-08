package com.bridgelabz.fellowship.JunitTesting;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:There is 1, 2, 5, 10, 50, 100, 500 and 1000 Rs Notes which can be returned by Vending Machine. Write a Program to calculate the minimum number of Notes as well as the Notes to be returned by the Vending Machine as a Change b
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.JunitTesting.utility.Utility;;

public class Vendingmachine 
{

	public static void main(String[] args) 
	{
		int i=0;
		int total=0;
		int[] notes= {1000,500,100,50,10,5,2,1};
		int money;
		System.out.println("enter the money");
		money=Inpututility.nextInt();
		Utility.calculate(money, notes,i,total);
	}


}