package com.bridgelabz.fellowship.Algorithm;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose: Reads in integers prints them in sorted order using Bubble Sort in generics
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
import com.bridgelabz.fellowship.utility.Inpututility;
import com.bridgelabz.fellowship.utility.LogUtility;

public class BubblesortGeneric<T extends Comparable<? super T>> {
	

	public static void main(String[] args) {
		LogUtility.setLog("BubblesortGeneric");
		Logger logger = LogUtility.getLog();

		try (BufferedReader buffer = new BufferedReader(new FileReader("F:\\testout1.txt"))) {

			ArrayList<String> al = new ArrayList<String>();
			while (buffer.ready()) {
				al.add(buffer.readLine());
			}
			logger.info("the array list is" + al);
			System.out.println("enter the keyword ALL to display all numbers from the file  ");
			String press = Inpututility.next();

			if (press.equals("all")) {
				String[] s = new String[al.size()];
				for (int j = 0; j < al.size(); j++) {
					s[j] = al.get(j);
					System.out.println(s[j]);

				}
				int size = s.length;
				Integer[] a = new Integer[size];// converting string[] to integer[] array
				for (int i = 0; i < size; i++) {
					a[i] = Integer.parseInt(s[i]);

				}
				logger.info("converting string[] to integer array");
				System.out.println("the integer  array" + Arrays.toString(a));
				Utility<Integer> u = new Utility<>();
				u.bubbleSort(a);
				System.out.println(java.util.Arrays.toString(a));
			}
		} catch (FileNotFoundException e) {
			logger.error("this should not be happened");

		} catch (IOException e) {

			logger.error("IOExceptions should not be happened");
		}
		System.out.println("logs have been writtened");

	}

}
