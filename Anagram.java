package com.bridgelabz.fellowship.Algorithm;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:One string is an anagram of another if the second is simply a rearrangement of the first. For example, 'heart' and 'earth' are anagrams... 
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

public class Anagram {

	public static void main(String[] args) {
		LogUtility.setLog("Anagram");
		Logger log = LogUtility.getLog();
		// Asks the user to enter the String1 and String2
		log.info("this is String1");
		System.out.println("enter the string s1");
		String s1 = Inpututility.nextLine();
		log.info("enter the string s2");
		System.out.println("this is String s2 ");
		String s2 = Inpututility.nextLine();
		try {
			Utility.isAnagram(s1, s2);

		} catch (CustomizedException e) {
			log.error("THIS KIND OF EXCEPTIONS SHOULD NOT OCCUR " + e);
		}

	}
}
