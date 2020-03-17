package com.bridgelabz.fellowship.datastructures;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose: Create a Program which creates Banking Cash Counter where people come in to deposit Cash and withdraw Cash. 
 * Have an input panel to add people to Queue to either deposit or withdraw money and dequeue the people.
 *  Maintain the Cash Balance. 
 **/


import org.apache.log4j.Logger;

import com.bridgelabz.fellowship.InputUtility.LogUtility;
/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import com.bridgelabz.fellowship.datastructures.utility.DataStructures;

public class BankingCashcounter 
{
	public static void main(String[] args) {
		LogUtility.setLog("BankingcashCounter");
		Logger log=LogUtility.getLog();	
		int cashcount1 = 10000;
		log.info("Banking cash counter main method");
		DataStructures.bankCashCounter(cashcount1);
	}
}
