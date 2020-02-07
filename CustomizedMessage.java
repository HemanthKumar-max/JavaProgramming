package com.bridgelabz.fellowship.Algorithm;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose: Read in the following message: Hello <<name>>, We have your full name as <<full name>> in our system. your contact number is 91-xxxxxxxxxx. Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016. Use Regex to replace name, full name, Mobile#, and Date with proper value. 
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bridgelabz.fellowship.Algorithms.Utility.Utility;
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.utility.LogUtility;

public class CustomizedMessage 
{
	
	public static void main(String[] args) 
	{
		

	  
		  LogUtility.setLog("CustomizedMessage");
			Logger logger=LogUtility.getLog();
		try( BufferedReader buffer=new BufferedReader(new FileReader("F:\\CustomizedMessage.txt")))
		{
		    logger.info("We use arraylist here to add all the elements from the file");
			
		    ArrayList<String>  al=new ArrayList<>();
			while(buffer.ready())
			{
				al.add(buffer.readLine());
			}
			System.out.println("enter the keyword ALL to read the text from a file  ");
			String press=Inpututility.nextLine();
			if(press.equals("all"))
			{
			String[] s=new String[al.size()];
			logger.info("creating the string array,to add all elements from arraylist to string array");
			for(int j=0;j<al.size();j++)
			{
				s[j]=al.get(j);
				
			}
			StringBuffer sb = new StringBuffer();
		    for(int i = 0; i < s.length; i++) {
		       sb.append(s[i]);
		    }
		    String str = sb.toString();
		    System.out.println(str);
			System.out.println();
			System.out.println();
			System.out.println("Give Details to get Modified Message:");
			System.out.println();
		     
		        System.out.println("enter the  name");
		        String s1=Inpututility.nextLine();
		        System.out.println("enter  the fullname");
		        String s2=Inpututility.nextLine();
		        System.out.println("enter phone no");
		        String s3=Inpututility.nextLine();
		        System.out.println("enter date");
		        String s4=Inpututility.nextLine();
		        
		        
		        String s5=Utility.replaceWithPattern(str, s1,s2,s3,s4);
		        System.out.println("the modified message is:");
		        System.out.println(s5);
		   
		        FileWriter fw = new FileWriter("F:\\newmessage.txt");
				fw.write(s5);
				fw.close(); 
				 System.out.println("the message has been writtened");
			        System.out.println("thank You");
					 
		}
		} catch (IOException e) {
			logger.error("this msg should not be appeared");
		}
		
		
		
		
		           
		       
		         
			
		
}
}
