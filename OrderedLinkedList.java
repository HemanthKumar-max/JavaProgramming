package com.bridgelabz.fellowship.datastructures;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:> Read .a List of Numbers from a file and arrange it ascending Order in a Linked List. Take user input for a number, if found then pop the number out of the list else insert the number in appropriate position b
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bridgelabz.fellowship.InputUtility.InputUtility;
import com.bridgelabz.fellowship.InputUtility.LogUtility;
import com.bridgelabz.fellowship.datastructures.utility.DataStructures;


public class OrderedLinkedList {
	public static void main(String[] args) 
	{
		LogUtility.setLog("OrderedLinkedList");
		@SuppressWarnings("unused")
		Logger log=LogUtility.getLog();
		
		
		final String PATH = "F:\\orderedlist.txt";
	    try (BufferedReader buffer=new BufferedReader(new FileReader(PATH)))
		{
    	   
		    ArrayList<String>  al=new ArrayList<>();
			while(buffer.ready())
			{
				al.add(buffer.readLine());
			}
			System.out.println("enter the keyword ALL to display all names from the file  ");
			String press=InputUtility.next();
			if(press.equals("all"))
			{
			String[] s=new String[al.size()];
			for(int j=0;j<al.size();j++)
			{
				s[j]=al.get(j);
				System.out.println(s[j]);
			}
			int size = s.length;
			int[] a = new int[size];// converting string[] to integer[] array
			for (int i = 0; i < size; i++)
			{
			  a[i] = Integer.parseInt(s[i]);
			}
			DataStructures.orderLinkedList(a, size);
			}
		} catch (IOException e) 
	    {
          e.printStackTrace();
		}
			
            
}
}
