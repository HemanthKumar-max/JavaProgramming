package com.bridgelabz.inventorymanager.utils;

import java.util.Random;
import java.util.Scanner;

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

	public static long inputLong() {
		return sc.nextLong();
	}


}
