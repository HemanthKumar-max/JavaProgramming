package com.bridgelabz.fellowship.JunitTesting;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:Write a Util Static Function to calculate ​monthlyPayment that reads in three  command-line arguments P, Y, and R and calculates the monthly payments you  would have to make over Y years to pay off a P principal loan amount at R percent interest compounded monthly.
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.JunitTesting.utility.Utility;

public class Monthlypayment
{
	public static void main(String[] args) 
	{
		System.out.println("enter the principal");
		int p=Inpututility.nextInt();
		System.out.println("enter the year");
		int y=Inpututility.nextInt();
		System.out.println("enter the rate of interest");
		int r=Inpututility.nextInt();
		Utility.payment(p, y, r);
	}
}
