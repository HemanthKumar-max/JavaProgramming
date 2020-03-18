package com.bridgelabz.oops.addressbook.utils;

import java.util.Scanner;

public class InputUtility {

	private static Scanner sc = new Scanner(System.in);

	/**
	 * private constructor to make the class as a Singleton class
	 */
	private InputUtility() {

	}

	/**
	 * static method to take byte from user
	 * 
	 * @return byte value which is given by user
	 */
	public static byte readByte() {
		return sc.nextByte();
	}

	/**
	 * static method to take short value from user
	 * 
	 * @return short value which is given by user
	 */
	public static short readShort() {
		return sc.nextShort();
	}

	/**
	 * static method to take int value from user
	 * 
	 * @return int value which is given by user
	 */
	public static int readInt() {
		return sc.nextInt();
	}

	/**
	 * static method to take long value from user
	 * 
	 * @return long value which is given by user
	 */
	public static long readLong() {
		return sc.nextLong();
	}

	/**
	 * static method to take float value from user
	 * 
	 * @return float value which is given by user
	 */
	public static float readFloat() {
		return sc.nextFloat();
	}

	/**
	 * static method to take double value from user
	 * 
	 * @return double value which is given by user
	 */
	public static double readDouble() {
		return sc.nextDouble();
	}

	/**
	 * static method to read char from user
	 * 
	 * @return character which is given by user
	 */
	public static char readChar() {
		return sc.next().charAt(0);
	}

	/**
	 * static method to read a group of characters from user
	 * 
	 * @return String value which is given by user
	 */
	public static String readString() {
		return sc.next();
	}

	/**
	 * static method to read a group of characters from user
	 * 
	 * @return String value which is given by user
	 */
	public static String readLine() {
		return sc.nextLine();
	}
	
	/**
	 * static method to take boolean value from user
	 * 
	 * @return boolean value which is given by user
	 */
	public static boolean readBoolean() {
		return sc.nextBoolean();
	}
}
