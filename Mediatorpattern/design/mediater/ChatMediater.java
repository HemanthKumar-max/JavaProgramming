package com.bridgelabz.Mediatorpattern.design.mediater;

public interface ChatMediater  
{
	public void sendMessage(String msg, User user);

	void addUser(User user);
}
