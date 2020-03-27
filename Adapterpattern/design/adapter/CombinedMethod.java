package com.bridgelabz.Adapterpattern.design.adapter;

import com.bridgelabz.Adapterpattern.model.Volts;

public class CombinedMethod {
	public static void testObjectAdapter() {
		SocketAdapter socket = new SocketObjectAdaptor();
		Volts v3 = getVolt(socket, 3);
		Volts v12 = getVolt(socket, 12);
		Volts v120 = getVolt(socket, 120);
		System.out.println("=============OBJECT ADAPTER VOLTS==========");
		System.out.println("volts v3 using object adapter="+v3.getVolts());
		System.out.println("volts v12 using object adapter="+v12.getVolts());
		System.out.println("volts v120 using object adapter="+v120.getVolts());
		System.out.println("=============================================");
	}

	public static void testClassAdapter() {
		SocketAdapter socket = new SocketClassAdapter();
		Volts v3 = getVolt(socket, 3);
		Volts v12 = getVolt(socket, 12);
		Volts v120 = getVolt(socket, 120);
		System.out.println("========CLASS ADAPTER VOLTS===============");
		System.out.println("volts v3 using class adapter="+v3.getVolts());
		System.out.println("volts v12 using class adapter="+v12.getVolts());
		System.out.println("volts v120 using class adapter="+ v120.getVolts());
		System.out.println("============================================");

	}

	private static Volts getVolt(SocketAdapter sockAdapter, int i) {
		switch (i) {
		case 3:
			return sockAdapter.get3Volts();
		case 12:
			return sockAdapter.get12Volts();
		case 120:
			return sockAdapter.get120Volts();
		default:
			return sockAdapter.get120Volts();
		}

	}
}