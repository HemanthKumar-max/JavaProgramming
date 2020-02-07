package com.bridgelabz.fellowship.Algorithm;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:Write a program to do Merge Sort of list of Strings.
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

public class MergeSort 
{
	
	public static void main(String[] args) 
	{
		LogUtility.setLog("MergeSort ");
		Logger logger=LogUtility.getLog();
	logger.info("size of String array1");	
	System.out.println("enter the size of String aray 1 ");
	int size1=Inpututility.nextInt();
	logger.info("size of String array2");
	System.out.println("enter the size of String aray 2 ");
	int size2=Inpututility.nextInt();
	String[] s1=new String[size1];
	String[] s2=new String[size2];
	System.out.println("enter the names for String array 1");
	for(int i=0;i<s1.length;i++)
	{
		s1[i]=Inpututility.nextLine();
	}
	System.out.println("enter the names for String array 2");
	for(int i=0;i<s2.length;i++)
	{
		s2[i]=Inpututility.nextLine();
	}
	String[] s=new String[s1.length+s2.length];
	Utility.mergesort(s1);
	Utility.mergesort(s2);
	Utility.merge(s,s1,s2);
	Utility.printArray(s);
	System.out.println("the sorted array is ");
	for(String s3: s)
	{
		System.out.println(s3);
		
	}
	
}
	}
