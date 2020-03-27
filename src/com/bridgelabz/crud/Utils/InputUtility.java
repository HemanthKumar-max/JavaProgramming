package com.bridgelabz.crud.Utils;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUtility {
	private static Scanner sc = new Scanner(System.in);
	private static final Random random = new Random();

	// InputUtility classes should not have public constructors.
	private InputUtility() {
		// By creating private constructor we can prevent creating objects of utility
		// from outside the class.
	}

	/***
	 * returns InputBoolean
	 * 
	 * @return
	 */
	public static boolean nextBoolean() {
		return sc.nextBoolean();
	}

	/***
	 * returns InputByteNoArgument
	 * 
	 * @return
	 */
	public static byte nextByte() {
		return sc.nextByte();
	}

	/***
	 * returns InputByteArgument0
	 * 
	 * @return
	 */
	public static byte nextByte(int arg0) {
		return sc.nextByte(arg0);
	}

	/***
	 * returns InputDouble
	 * 
	 * @return
	 */
	public static double nextDouble() {
		return sc.nextDouble();
	}

	/***
	 * returns InputFloat
	 * 
	 * @return
	 */
	public static float nextFloat() {
		return sc.nextFloat();
	}

	/***
	 * returns InputInteger
	 * 
	 * @return
	 */
	public static int nextInt() {
		return sc.nextInt();
	}

	/***
	 * returns InputString
	 * 
	 * @return
	 */
	public static String nextLine() {
		return sc.nextLine();
	}

	public static String next() {
		return sc.next();
	}

	/***
	 * returns InputString
	 * 
	 * @return
	 */

	/***
	 * returns InputLong
	 * 
	 * @return
	 */
	public static long nextLong() {
		return sc.nextLong();
	}

	/***
	 * returns InputShort
	 * 
	 * @return
	 */
	public static short nextShort() {
		return sc.nextShort();
	}

	/***
	 * returns InputRemove
	 * 
	 * @return
	 */
	public static void remove() {
		sc.remove();
	}

	public static String inputString() {
		return sc.next();
	}

	/*
	 * Return Input String
	 */
	public static String inputStringLine() {
		try {
			return sc.nextLine();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/*
	 * Return Input Boolean
	 */
	public static boolean inputBoolean() {
		try {
			return sc.nextBoolean();
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	/*
	 * Check User Input Value is Number
	 */
	public static boolean checkNumber(int userNumber) {
		if (userNumber >= '0' && userNumber <= '9') {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Inventory Management
	 */
	public static boolean checkChoice(int choice) {
		if (choice == 0 || choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6
				|| choice == 7) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * Check Choice for Rice Wheat
	 */
	public static boolean checkChoiceOne(int choice) {
		if (choice == 1 || choice == 2 || choice == 3) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * method to check number
	 */
	public static boolean checkNumber(long currentAmount) {
		if (currentAmount >= 'A' && currentAmount <= 'Z' || currentAmount == 'a' && currentAmount == 'z') {
			return false;
		}
		while (currentAmount != 0) {
			long rem = currentAmount % 10;
			currentAmount = currentAmount / 10;
			if (rem == 0 || rem == 1 || rem == 2 || rem == 3 || rem == 4 || rem == 5 || rem == 6 || rem == 7 || rem == 8
					|| rem == 9)
				return true;
		}
		return false;
	}

	public static boolean checkString(String string) {
		char charcter[] = string.toCharArray();
		for (int i = 0; i < charcter.length; i++) {
			if (charcter[i] >= 'A' && charcter[i] <= 'Z' || charcter[i] == 'a' && charcter[i] == 'z') {
				return true;
			}
		}
		return false;
	}

	public static boolean stringChecker(String str) {
		char[] ch = str.toCharArray();
		@SuppressWarnings("unused")
		String temp = "";
		Predicate<Character> p = s -> s >= 97 && s <= 122 || s >= 65 && s <= 90 || s >= 48 && s <= 57;
		for (char i : ch) {
			if (p.test(i)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Integer check
	 */
	public static boolean checkInteger(String number) {
		char ch[] = number.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= 48 && ch[i] <= 57) {
				return true;
			}
		}
		return false;
	}

	/*
	 * @param-type: integer
	 * 
	 * @return-type: boolean
	 * 
	 */
	public boolean validOption(int option) {
		if (option == 1 || option == 2 || option == 3)
			return true;
		return false;
	}

	public static String doctorId() {
		String output = "";
		String doctorId = "DOC";
		for (int i = 0; i < 3; i++) {
			output += random.nextInt(10);
		}
		int outputInt = Integer.parseInt(output);
		return doctorId += outputInt;

	}

	public static String patientId() {
		String output = "";
		String doctorId = "PAT";
		for (int i = 0; i < 3; i++) {
			output += random.nextInt(10);
		}
		int outputInt = Integer.parseInt(output);
		return doctorId += outputInt;

	}

	public static boolean mobileNumberValidator(String number) {
		if (number.matches("^[789]\\d{9}$")) {
			return true;
		}
		return false;
	}

	public static boolean intChecker(String number) {
		// regular expression for an integer number
		String regex = "[+-]?[0-9][0-9]*";

		// compiling regex
		Pattern p = Pattern.compile(regex);

		// Creates a matcher that will match input1 against regex
		Matcher m = p.matcher(number);

		if (m.find() && m.group().equals(number))
			return true;

		return false;

	}

	/*
	 * METHOD TO QUIT
	 */
	public static void quit() {
		System.exit(0);
	}

	/*
	 * METHOD TO CHECK STRING ALPHA
	 */
	public static boolean isStringOnlyAlphabet(String str) {
		return ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$")));
	}

	public static int inputIntegerOne() {
		try {

			return Integer.parseInt(sc.nextLine());

		} catch (Exception e) {
			System.out.println("Invalied Input");
		}
		return 0;
	}

	public static long inputLong() {
		return sc.nextLong();
	}
}
