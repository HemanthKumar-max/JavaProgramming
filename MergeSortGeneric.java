package com.bridgelabz.fellowship.Algorithm;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:Write a program to do Merge Sort of list of Strings in generics.
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/


import org.apache.log4j.Logger;

/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.Algorithms.Utility.Utility;
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.utility.LogUtility;



public class MergeSortGeneric 
{
	
	
	public static void main(String[] args) 
	{
		LogUtility.setLog("MergeSortGeneric ");
		Logger logger=LogUtility.getLog();
		Utility<String> u=new Utility<>();
		Utility<Integer> u1=new Utility<>();
		logger.info("size of String array1");
	System.out.println("enter the size of String aray ");
	int size=Inpututility.nextInt();
	
	String[] s1=new String[size];
	logger.info("Names of String array1");
	System.out.println("enter the names for String array ");
	for(int i=0;i<s1.length;i++)
	{
		s1[i]=Inpututility.next();
	}
	
	u.mergeSort(s1, 0, s1.length-1);
	System.out.println(java.util.Arrays.toString(s1));
	
	
	logger.info("size of Integer array1");
	 System.out.println("enter the size of integer aray ");
		int size1=Inpututility.nextInt();
	Integer[] s=new Integer[size1];
	
	logger.info("Names of Integer array1");
	System.out.println("enter the names for Integer array ");
	for(int i=0;i<s.length;i++) 
	{
		s[i]=Inpututility.nextInt();
	}
	u1.mergeSort(s, 0, s.length-1);
	System.out.println(java.util.Arrays.toString(s));
}
}
