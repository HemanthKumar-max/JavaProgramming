package com.bridgelabz.fellowship.LogicalPrograms;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:Simulates a gambler who start with $stake and place fair $1 bets until he/she goes broke (i.e. has no money) or reach $goal. Keeps track of the number of times he/she wins and the number of bets he/she makes. Run the experiment N times, averages the results, and prints them out.
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.LogicalPrograms.utility.Utility;
import com.bridgelabz.fellowship.utility.Inpututility;


public class Gambler 
{
	public static void main(String[] args) 
	{
		System.out.println("enter the stake value ");
		int stake=Inpututility.nextInt();
		System.out.println("enter the goal to be reached");
		int goal=Inpututility.nextInt();
		System.out.println("enter the no of trials");
		int trials=Inpututility.nextInt();
		Utility.gambler(stake, goal, trials);
	}
}
