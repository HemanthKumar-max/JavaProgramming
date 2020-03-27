package com.bridgelabz.Adapterpattern.design.adapter;

import com.bridgelabz.Adapterpattern.model.Socket;
import com.bridgelabz.Adapterpattern.model.Volts;

public class SocketObjectAdaptor implements SocketAdapter {
	private Socket socket = new Socket();

	@Override
	public Volts get120Volts() {
		return socket.getVolts();
	}

	@Override
	public Volts get12Volts() {
		Volts v = socket.getVolts();
		return convertVolts(v, 10);
	}

	@Override
	public Volts get3Volts() {
		Volts v = socket.getVolts();
		return convertVolts(v, 40);
	}

	public Volts convertVolts(Volts v, int i) {
		return new Volts(v.getVolts() / i);
	}

}
