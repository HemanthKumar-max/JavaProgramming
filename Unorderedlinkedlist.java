package com.bridgelabz.fellowship.datastructures;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.0
 * Purpose: Read the Text from a file, split it into words and arrange it as Linked List. 
 * Take a user input to search a Word in the List. If the Word is not found then add it to the list, and 
 * if it found then remove the word from the List. In the end save the list into a file.
 **/

import com.bridgelabz.fellowship.InputUtility.InputUtility;
import com.bridgelabz.fellowship.datastructures.utility.DataStructures;

public class Unorderedlinkedlist {
	public static void main(String[] args) {
		System.out.println("Enter the word you want to search :");
		String item = InputUtility.nextLine();
		DataStructures.unOrderLinkedList(item);
	}
}
