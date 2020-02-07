package com.bridgelabz.fellowship.Algorithm;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose: ​Output​ ​T ​ lines. The ​ith ​ line contains the value of the maximum amount by which a task's completion time overshoots its deadline, when the first tasks on your list are scheduled optimally.
 **/


/**
 * Here import the utility package  to use the Utility class in a program.
 **/


import org.apache.log4j.Logger;

/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.utility.LogUtility;

public class TaskScheduling 
{
	
	public static void main(String[] args) {
		LogUtility.setLog("TaskScheduling");
		Logger logger=LogUtility.getLog();			
	logger.info("number of tasks");	
	System.out.println("enter the number of tasks");
	int task=Inpututility.nextInt();
	int[] deadline=new int[task];
	int[] min=new int[task];
	for (int i = 0; i < min.length; i++) {
		System.out.println("task " +i+ " time");
		min[i] = Inpututility.nextInt();
		System.out.println("task "+i+" deadline");
		deadline[i] = Inpututility.nextInt();
}
}
}