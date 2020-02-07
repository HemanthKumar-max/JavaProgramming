package com.bridgelabz.fellowship.Algorithm;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:Creating of a custom exception class.By using this class you can throw your own customException.
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/
public class CustomizedException extends Exception 
{
	public CustomizedException(String msg) 
	{
	super(msg);
	}
}
