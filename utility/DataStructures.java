package com.bridgelabz.fellowship.datastructures.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;

import com.bridgelabz.fellowship.InputUtility.InputUtility;
import com.bridgelabz.fellowship.InputUtility.LogUtility;
import com.bridgelabz.fellowship.datastructures.Dequeue;
import com.bridgelabz.fellowship.datastructures.LinkedList;
import com.bridgelabz.fellowship.datastructures.Queue;
import com.bridgelabz.fellowship.datastructures.QueueImplementationUsingLL;
import com.bridgelabz.fellowship.datastructures.Stack;
import com.bridgelabz.fellowship.datastructures.StackLinkedList;

public class DataStructures {
	
	static Logger log = LogUtility.getLog();
	static int[][] calender = new int[5][7];// 7->days of a week,5->weeks in a month
	static int[] month = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static BufferedReader bufferReader;
	private static String Path2;
	private DataStructures() {
		// constructor stub
	}

	/**
	 * Define static function unOrderLinkedList
	 * 
	 * @param item
	 *            --> String
	 * @return void
	 */
	private static final String PATH = "F:\\Unorderedlist.txt";
	private static final String PATH1 = "F:\\Unorderedlist1.txt";
	public static void unOrderLinkedList(String item) {
		try (FileWriter fileWriter = new FileWriter(PATH1);) {
			LinkedList<String> list = new LinkedList<>();
			String string = DataStructures.readFromFile(PATH);
			String[] words = string.split(" ");
			for (String word : words)
				list.add(word);
			if (list.search(item)) {
				list.removeItem(item);
			} else {
				list.add(item);
			}
			list.display();
			int size = list.size();//
			for (int conut = 0; conut <= size; conut++) {
				fileWriter.write(list.pop(0) + " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * writing the data in the file
	 * 
	 * @param array
	 *            ==> String[]
	 * @param filename
	 *            ==> String
	 * @return void
	 */
	
	

	/**
	 * writing the data in the file
	 * 
	 * @param data
	 *            ==> String
	 * @param filename
	 *            ==> String
	 * @return boolean
	 * @throws IOException
	 */

	public static boolean writeToFile(String data, String filename) throws IOException {
		File file = new File(filename);
		if (!file.exists()) {
			file.createNewFile();
		
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)))) {
				bw.write(data);
				bw.flush();
				
			}
			catch (IOException e) {
			 e.printStackTrace();
			}
		}
		return true;

	}

	/**
	 * writing the data in the file
	 * 
	 * @param array
	 *            ==> int[][]
	 * @param rows
	 *            ==> int
	 * @param cols
	 *            ==> int
	 * @param filename
	 *            ==> String
	 * @return boolean
	 * @throws IOException 
	 */
	

	/**
	 * to read the data from the file
	 * 
	 * @param filename
	 *            ==> String
	 * @return String
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static String readFromFile(String filename) {
		try (BufferedReader bufferReader = new BufferedReader(new FileReader(filename))) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = bufferReader.readLine()) != null)
				sb.append(line);
			return sb.toString();
		} catch (IOException e) {
			System.out.println("Empty file " + e.getMessage());
		}
		return filename;
	}

	/**
	 * Define static function OrderLinkedList
	 * 
	 * @param item
	 *            --> Integer
	 * @return 
	 * @return void
	 */
	
	static final String PATH2 = "F:\\orderedlist2.txt";
	public static void orderLinkedList(int[] a, int size)
	{
		
		try (FileWriter f = new FileWriter(PATH2);) 
		{
		LinkedList<Integer> l = new LinkedList<>();
		System.out.println("the integer  array" + Arrays.toString(a));

		for (int num : a)// int[] to int
		{
			l.add(num);
		}
		System.out.println();
		l.display();
	    System.out.println();
		System.out.println("enter the number to be searched");
		int item = InputUtility.nextInt();
		if (l.search(item)) {
			l.removeItem(item);// removing the item if its already in file
			DataStructures.bubbleSort(a, size);		
		} else {
			System.out.println("Adding Elements");
			l.add(item); // adding the item into file
		}
		System.out.println("the display is");
		ArrayList<String> al= l.display();
	    System.out.println("al is"+al);
		for(String s:al)
		{
			f.write(s);
			
		}
		System.out.println("written into file");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Define static function balancedParenthesis() to balanced the parenthesis
	 * 
	 * @param exp
	 *            --> char
	 * @param length
	 *            --> int
	 * @return boolean
	 */
	public static boolean balancedParenthesis(char[] exp, int length) {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Stack<Integer> stack = new Stack(length);
		log.info("To check the paranthesis in expression");
		// logic to check parenthesis in expression
		for (int count = 0; count < length; count++) {
			if (exp[count] == '{' || exp[count] == '(' || exp[count] == '[')
				stack.push(exp[count]);
			if (exp[count] == '}' || exp[count] == ')' || exp[count] == ']') {
				if (stack.isEmpty()) {
					return false;
				} else {
					if (!isMatchingPair(stack.pop(), exp[count]))
						return false;
				}
			}
		}
		log.info("----> if Stack is empty!!");
		if(stack.isEmpty())
			
			return true;
		return false;
		
	
	}

	/**
	 * define static function isMatchingPair() to match the opened and closed
	 * parenthesis to make pairs
	 * 
	 * @param ch1
	 *            ==> char
	 * @param ch2
	 *            ==> char
	 * @return boolean
	 */
	public static boolean isMatchingPair(char character1, char character2) {
		if (character1 == '(' && character2 == ')')
			return true;
		else if (character1 == '{' && character2 == '}')
			return true;
		else if (character1 == '[' && character2 == ']')
			return true;
		else
			return false;
	}

	/**
	 * define static function BankCashCounter()
	 * 
	 * @param cash_count
	 *            ==> int
	 * @return boolean
	 */
	public static boolean bankCashCounter(int cashcount1) {
		Queue<Integer> q = new Queue<>();
		int count = 0;
		do {
			
			System.out.println("-----------Banking Cash Counter------------");
			System.out.println("Enter the choice");
			System.out.println("1:Add People  2:Cash Check  3:Exit");
			int choice = InputUtility.nextInt();
			switch (choice) {

			case 1:
				int cashcount = 0;
				q.enQueue(count++);
				System.out.println("Adding " + count + " person to the queue");
				System.out.println("Do you want to: 1-Deposit 2-Withdraw");

				int ch = InputUtility.nextInt();
				switch (ch) {
				case 1:
					System.out.println("Enter the amount to deposit");
					int depamt = InputUtility.nextInt();

					cashcount += depamt;
					cashcount1 = cashcount1 + cashcount;
					System.out.println(depamt + " is added to" + count + " persons account");
					System.out.println("total bank balance" + cashcount1);
				case 2:
					System.out.println("Enter the amount to withdraw");
					int withdraw = InputUtility.nextInt();
					if (withdraw > cashcount) {
						System.out.println("Cash of that amount is not available in" + count + "person account");
					} else {
						cashcount -= withdraw;
						System.out.println(withdraw + " is withdrawn");
						System.out.println("the remaing balance of person " + cashcount);
						cashcount1 = cashcount1 - withdraw;
						System.out.println("total bank balance after withdrawing " + cashcount1);
					}
					break;
				default:
					System.out.println("Invalid choice");
					System.exit(0);
				}
				q.deQueue();
				System.out.println("The person is removed");
				break;
			case 2:
				System.out.println("The amount of cash available in bank is: " + cashcount1);
				break;
			case 3:
				System.exit(0);
			}
		} while (cashcount1 != 0);
		System.out.println("Ran out of cash");
		return false;
	}

	/**
	 * Define Boolean Function Palindrome checker()
	 * 
	 * @param s
	 *            --> String
	 * @return Boolean
	 */
	public static boolean palindromeChecker(String string) {
		Dequeue<Character> utility = new Dequeue<>();

		// adding each character to the rear of the deque
		for (int count = 0; count < string.length(); count++) {
			char ch = string.charAt(count);
			utility.addRear(ch);
		}
		int flag = 0;

		while (utility.size() > 1) {
			if (utility.removeFront() != utility.removeRear()) {
				flag = 1;
				break;
			}
		}

		if (flag == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Define Boolean Function displayPalindrome checker()
	 * 
	 * @param s
	 *            --> String
	 * @return void
	 */
	public static void displayPalindromeChecker(String s) {

		if (palindromeChecker(s)) {

			System.out.println("String is  palindrome");
		} else {
			System.out.println("String is not palindrome");
		}
	}

	/**
	 * Define Boolean Function Prme2D()
	 * 
	 * @return Boolean
	 * @throws IOException
	 */
	static final String PATH3 = "F:\\primenumber.txt";
	public static boolean prime2D() throws IOException {
		int number = 1;
		int[][] primeNumber = new int[10][100];
		// logic to check the number is prime or not
		for (int count = 0; count < 10; count++) {
			for (int count1 = 0; count1 < 100; count1++) {
				if (DataStructures.isPrime(number)) {
					primeNumber[count][count1] = number;
				} else {
					primeNumber[count][count1] = -1;
				}
				number++;
			}
		}
		// empty string to store prime numbers
		String prime = "";
		for (int j[] : primeNumber) {
			for (int i : j) {
				if (i != -1 && i != 1) {
					System.out.print(i + " ");
					prime = prime + i + " ";
				}
			}
			System.out.println();
		}
		boolean status = DataStructures.writeToFile(prime, PATH3);
		System.out.println(status);
		return status;
	}

	/**
	 * Define Boolean Function primeAnagramPrint()
	 * 
	 * @return void
	 */
	public static void primeAnagramPrint() {
		int arr[] = new int[1000];
		// logic to check the prime numbers
		int number = 2;
		for (int count = 0; count < arr.length; count++) {
			if (DataStructures.isPrime(number)) {

				arr[count] = number;
			}
			number++;
		}
		System.out.println("Numbers that are prime and anagram : ");

		// logic to check prime numbers are anagram or not
		for (int k = 0; k < arr.length; k++) {
			for (int j = k + 1; j < arr.length; j++) {
				if (DataStructures.isAnagram(arr[k], arr[j]) && (arr[k] != 0 && arr[j] != 0)) {
					System.out.println(arr[k] + " " + arr[j]);

				}
			}
		}

	}

	/**
	 * Define Boolean Function primeAnagramUSingStack()
	 * 
	 * @return void
	 */
	public static void primeAnagramUsingStack() {
		StackLinkedList<Integer> stack = new StackLinkedList<>();

		// logic to push the prime number into stack
		for (int i = 2; i <= 1000; i++) {
			if (DataStructures.isPrime(i)) {
				stack.push(i);
			}
		}

		// logic to store prime numbers from stack to array
		int size = stack.size();
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = stack.pop();
		}

		// logic to check prime numbers are anagram or not
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (DataStructures.isAnagram(array[i], array[j]) && array[i] != 0 && array[j] != 0) {
					System.out.println(array[i] + " " + array[j]);
				}
			}
		}
	}

	/**
	 * Define Boolean Function primeAnagramUsingQueue()
	 * 
	 * @return void
	 */
	public static void primeAnagramUsingQueue() {
		Queue<Integer> queue = new Queue<>();

		// Logic to check the number is prime or not
		for (int i = 2; i <= 1000; i++) {
			if (DataStructures.isPrime(i)) {
				queue.enQueue(i);
			}
		}

		int size = queue.getSize();
		int[] array = new int[size];

		// Logic to dequeue the number and store the numbers into array
		for (int i = 0; i < size; i++) {
			array[i] = queue.deQueue();
		}

		// Logic to check the prime numbers are anagram and store in queue
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (DataStructures.isAnagram(array[i], array[j]) && array[i] != 0 && array[j] != 0) {
					queue.enQueue(array[i]);
					queue.enQueue(array[j]);
				}
			}
		}
		queue.display();
	}

	/**
	 * to check the number is prime or not
	 * 
	 * @param num
	 *            ==> int
	 * @return boolean
	 */
	public static boolean isPrime(int num) {
		boolean flag = true;
		for (int count = 2; count <= num / 2; count++) {
			if (num % count == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static int countDigits(int num) {
		int count = 0;
		while (num != 0) {
			num = num / 10;
			++count;
		}
		return count;
	}

	/**
	 * to check the number is anagram or not
	 * 
	 * @param n1
	 *            ==> int
	 * @param n2
	 *            ==> int
	 * @return boolean
	 */
	public static boolean isAnagram(int n1, int n2) {
		int len1 = countDigits(n1);
		int len2 = countDigits(n2);
		if (len1 != len2) {
			return false;
		}
		int i = 0;
		int j = 0;
		int[] num1 = new int[len1];
		int[] num2 = new int[len2];
		while (n1 != 0) {
			int rem = n1 % 10;
			num1[i] = rem;
			n1 = n1 / 10;
			i++;
		}
		while (n2 != 0) {
			int rem = n2 % 10;
			num2[j] = rem;
			n2 = n2 / 10;
			j++;
		}
		Arrays.sort(num1);
		Arrays.sort(num2);
		if (Arrays.equals(num1, num2))
			return true;
		else
			return false;
	}

	/**
	 * Define Boolean Function bubbleSort()
	 * 
	 * @param arr[]
	 *            --> int
	 * @param length
	 *            --> int
	 * @return int
	 */
	public static int[] bubbleSort(int[] arr, int length) {
		// Logic to sort the array
		int i, j, temp;
		for (i = 0; i < length; i++) {
			int flag = 0;
			for (j = 0; j < length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					// swapping the two elements in array to sort the array
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = 1;
				}
			}
			if (flag == 0) {
				break;
			}
		}
		for (i = 0; i < length; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

	static void initcal() {
		for (int i = 0; i < calender.length; i++) {
			for (int j = 0; j < calender[i].length; j++) {
				calender[i][j] = -10;
			}
		}
	}

	/**
	 * Define static method display(),to print the calender of the day of month.
	 * 
	 * @param m
	 *            --->int
	 * @return void
	 */
	static void display(int m) {
		System.out.println("Sun	Mon	Tue	Wed	Thu	Fri	Sat");

		for (int i = 0; i < calender.length; i++) {
			for (int j = 0; j < calender[i].length; j++) {
				if (calender[i][j] < 0 || calender[i][j] > month[m - 1]) {
					System.out.print("\t ");
				} else if (calender[i][j] > 0) {
					System.out.print("\t" + calender[i][j] + " ");
				}
			}
			System.out.println("\t");
		}
	}

	static void putCalender(int d) {
		int d1 = 1;
		for (int i = d; i < calender[0].length; i++) {

			calender[0][i] = d1++;
		}
		for (int i = 1; i < calender.length; i++) {
			for (int j = 0; j < calender[i].length; j++) {
				calender[i][j] = d1++;
			}
		}

	}

	/**
	 * Define static function dispcalender() to display the calender.
	 * 
	 * @param m
	 *            --->int
	 * @param y
	 *            --->int
	 * @return void
	 */
	public static void dispCalender(int m, int y) {
		int d = dayOfWeek(m, y);
		initcal();
		putCalender(d);
		display(m);

	}

	/**
	 * Define the static function Dayofweek(),to calculate the day of the month.
	 * 
	 * @param m
	 *            -->int
	 * @param y
	 *            --->int
	 * 
	 * @return int
	 */
	public static int dayOfWeek(int m, int y) {
		int d = 1;
		int y0 = y - (14 - m) / 12;
		int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
		int m0 = m + 12 * ((14 - m) / 12) - 2;
		int d0 = (d + x + (31 * m0) / 12) % 7;
		return d0;

	}

	/**
	 * Purpose: method for checking year is leap or not
	 * 
	 * @param year
	 *            input from user
	 * @return returns true if leap year else false
	 */
	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 || year % 400 == 0 && year % 100 != 0)
			return true;
		else
			return false;
	}

	/***
	 * 
	 * @param day
	 * @param days
	 */
	public static void printCalendarUsingQueue(int day, int days) {
		QueueImplementationUsingLL<String> weekDayQueue = new QueueImplementationUsingLL<String>();
		QueueImplementationUsingLL<String> weekDateQueue = new QueueImplementationUsingLL<String>();
		String weekdaystr = "SUN MON TUE WED THU FRI SAT";
		String[] weekdaystrarr = weekdaystr.split(" ");
		for (int i = 0; i < weekdaystrarr.length; i++) {
			weekDayQueue.enQueue(weekdaystrarr[i]);
		}
		weekDayQueue.show();
		switch (day) {
		case 0:

			for (int i = 1; i <= days; i++) {
				if (i <= 9) {
					weekDateQueue.enQueue(i + "   ");
				} else {
					weekDateQueue.enQueue(i + "  ");
				}
				if (i % 7 == 0) {
					weekDateQueue.enQueue("\n");
				}
			}
			break;
		case 1:

			System.out.print("    ");
			for (int i = 1; i <= days; i++) {

				if (i <= 9) {
					weekDateQueue.enQueue(i + "   ");
				} else {
					weekDateQueue.enQueue(i + "  ");
				}
				if (i == 6 || i == 13 || i == 20 || i == 27) {
					weekDateQueue.enQueue("\n");
				}
			}
			break;
		case 2:

			System.out.print("        ");
			for (int i = 1; i <= days; i++) {

				if (i <= 9) {
					weekDateQueue.enQueue(i + "   ");
				} else {
					weekDateQueue.enQueue(i + "  ");
				}
				if (i == 5 || i == 12 || i == 19 || i == 26) {
					weekDateQueue.enQueue("\n");
				}
			}
			break;
		case 3:

			System.out.print("            ");
			for (int i = 1; i <= days; i++) {

				if (i <= 9) {
					weekDateQueue.enQueue(i + "   ");
				} else {
					weekDateQueue.enQueue(i + "  ");
				}
				if (i == 4 || i == 11 || i == 18 || i == 25) {
					weekDateQueue.enQueue("\n");
				}
			}
			break;
		case 4:

			System.out.print("                ");
			for (int i = 1; i <= days; i++) {

				if (i <= 9) {
					weekDateQueue.enQueue(i + "   ");
				} else {
					weekDateQueue.enQueue(i + "  ");
				}
				if (i == 3 || i == 10 || i == 17 || i == 24) {
					weekDateQueue.enQueue("\n");
				}
			}
			break;
		case 5:

			System.out.print("                    ");
			for (int i = 1; i <= days; i++) {

				if (i <= 9) {
					weekDateQueue.enQueue(i + "   ");
				} else {
					weekDateQueue.enQueue(i + "  ");
				}
				if (i == 2 || i == 9 || i == 16 || i == 23 || i == 30) {
					weekDateQueue.enQueue("\n");
				}
			}
			break;
		case 6:

			System.out.print("                        ");
			for (int i = 1; i <= days; i++) {

				if (i <= 9) {
					weekDateQueue.enQueue(i + "   ");
				} else {
					weekDateQueue.enQueue(i + "  ");
				}
				if (i == 1 || i == 8 || i == 15 || i == 22 || i == 29) {
					weekDateQueue.enQueue("\n");
				}
			}
			break;
		}

		System.out.println(weekDateQueue.showQueueWithoutSpace());
	}

}
