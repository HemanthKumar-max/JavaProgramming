package com.bridgelabz.fellowship.LogicalPrograms;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:> Write a Stopwatch Program for measuring the time that elapses between the start and end clicks .
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.utility.Inpututility;

import com.bridgelabz.fellowship.LogicalPrograms.utility.Utility;
public class Stopwatch 
{

	static long start=0;
	static long stop=0;
	public static void main(String[] args) 
	{
		System.out.println("press 1 to start");
		@SuppressWarnings("unused")
		int a=Inpututility.nextInt();
		long start1=Utility.start(start);
		System.out.println("press 2 to stop");
		@SuppressWarnings("unused")
		int b=Inpututility.nextInt();
		long stop1=Utility.stop(stop);
		double l=Utility.elapsedTime(start1,stop1);
		System.out.println();
		System.out.println("total time elapsed in milliseconds"+l);
		System.out.println();
		System.out.println("converting millisec to seconds"+(l/1000)+"seconds");
	}
}
