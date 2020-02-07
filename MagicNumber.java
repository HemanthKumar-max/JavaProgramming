package com.bridgelabz.fellowship.Algorithm;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:> takes a command-line argument N, asks you to think of a number between 0 and N-1, where N = 2^n, and always guesses the answer with n questions. 
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/

import org.apache.log4j.Logger;

/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.Algorithms.Utility.Utility;
import com.bridgelabz.fellowship.utility.LogUtility;

public class MagicNumber 
{
	
	public static void main(String[] args) 
	{
		LogUtility.setLog("MagicNumber ");
		Logger logger=LogUtility.getLog();
	int n=Integer.parseInt(args[0]);
	int N=(int)Math.pow(2, n);
	logger.info("enter the  number between 0 and (N-1)");
	System.out.println("think of a number between "+0+" and "+(N-1));
    int res =Utility.magicnum(0, N);
    System.out.println("the magic number is"+res);
	
}
}
