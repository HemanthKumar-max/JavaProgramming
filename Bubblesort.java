package com.bridgelabz.fellowship.Algorithm;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose: Reads in integers prints them in sorted order using Bubble Sort 
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;

import com.bridgelabz.fellowship.Algorithms.Utility.Utility;
import com.bridgelabz.fellowship.datastructures.CustomizedException;
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.utility.LogUtility;

public class Bubblesort 
{
	
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
    	
	bubblesortexception();	
		
   }

    public static void bubblesortexception() throws FileNotFoundException, IOException
    {
    	
    	try(BufferedReader buffer= new BufferedReader(new FileReader("F:\\testout1.txt")))
	  {
		LogUtility.setLog("Bubblesort");
		Logger log=LogUtility.getLog();
		
		  log.info("Adding all the numbers from file to arraylist");
	     	ArrayList<String>  al=new ArrayList<>();
			while(buffer.ready())
			{
				al.add(buffer.readLine());
				
				
			}
			System.out.println("enter the keyword ALL to display all numbers from the file  ");
			String press=Inpututility.next();
			if(press.equals("all"))
			{
			String[] s=new String[al.size()];
			for(int j=0;j<al.size();j++)
			{
				s[j]=al.get(j);
				System.out.println(s[j]);
			}
			int size=s.length;
			int[] a=new int[size];//converting string[] to integer[] array
			for(int i=0; i<size; i++)
			{
		         a[i] = Integer.parseInt(s[i]);
		    }
		      System.out.println("the integer  array"+Arrays.toString(a));
		    
			Utility.bubblesort(a);
			log.info("after sorting bubblesort");
			Utility.printArray(a); 
			log.info("After printing bubblesort");
			
			
	   }
	}
	
    }
}