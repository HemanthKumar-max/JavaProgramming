package com.fundoonote.noteapi;

public interface JmsClient {
	public void send(String msg);
	public String receive();
}
