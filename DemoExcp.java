package com.bridgelabz.fellowship.basicCoreprograms;

class excp extends Exception {

	private static final long serialVersionUID = 1L;

	public excp(String msg) {
		super(msg);
	}
}

public class DemoExcp {
	public static void main(String[] args) {
		try {
			System.out.println("A");
			System.out.println(10 / 0);
		} catch (ArithmeticException e) {
			System.out.println("Not div by Zero");
		} finally {
			System.out.println("D");
		}
	}
}
