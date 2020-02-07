package com.bridgelabz.fellowship.Algorithm;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose: Reads in strings and prints them in sorted order using insertion sort in generics.
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import org.apache.log4j.Logger;

import com.bridgelabz.fellowship.Algorithms.Utility.Utility;
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.utility.LogUtility;



public class InsertionSortGenerics 
{
	
public static void main(String[] args) 
	{
	LogUtility.setLog("InsertionSortGenerics ");
	Logger logger=LogUtility.getLog();
		try(BufferedReader buffer=new BufferedReader(new FileReader("F:\\testout2.txt")))
		{
			logger.info("Here Arraylist is used to add all elements from file");
			ArrayList<String>  al=new ArrayList<>();
			while(buffer.ready())
			{
				al.add(buffer.readLine());
			}
			
			System.out.println("enter the keyword ALL to display all names from the file  ");
			String press=Inpututility.next();
			if(press.equals("all"))
			{
			String[] s=new String[al.size()];
			for(int j=0;j<al.size();j++)
			{
				s[j]=al.get(j);
				System.out.println(s[j]);
			}
			
	        Utility<String> u=new Utility<>();
			u.insertionSort(s);
			System.out.println(java.util.Arrays.toString(s));
		}
		}
		catch (FileNotFoundException e)
		{
			logger.error("FilenotFound Exception should not be occured  "+e);
		}  
		catch (IOException e1) {
			logger.error("IOException should not be occured");
			
		}
		
		
			
	}
}


