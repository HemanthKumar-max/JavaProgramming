package com.bridgelabz.fellowship.datastructures;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:Write a Stack Class to push open parenthesis “(“ and pop closed parenthesis “)”. At the End of the Expression if the Stack is Empty then the 
   Arithmetic Expression is Balanced. Stack Class Methods are Stack(), push(), pop(), peak(), isEmpty(), size() d
 **/

/**
 * Here import the utility package to use the Utility class in a program.
 **/
import org.apache.log4j.Logger;

/**
 * Here import the utility package  to use the Utility class in a program.
 **/





import com.bridgelabz.fellowship.InputUtility.InputUtility;
import com.bridgelabz.fellowship.InputUtility.LogUtility;
import com.bridgelabz.fellowship.datastructures.utility.DataStructures;

public class Balancedparanthises {
	public static void main(String[] args) {

		LogUtility.setLog("Balancedparanthises");
		Logger logger=LogUtility.getLog();	
		System.out.println("Enter the expression : ");
		char[] exp = InputUtility.inputStringLine().toCharArray();
		int length = exp.length;

		// checking the parenthesis is balanced or not
		if (DataStructures.balancedParenthesis(exp, length))
			System.out.println("Balanced");
		else
			System.out.println("Unbalanced");
	}
}
