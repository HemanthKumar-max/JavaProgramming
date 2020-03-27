package com.bridgelabz.Adapterpattern.design.adapter;

import com.bridgelabz.Adapterpattern.model.Volts;

public interface SocketAdapter {
	public Volts get120Volts();

	public Volts get12Volts();

	public Volts get3Volts();

}
