package com.bridgelabz.Mediatorpattern.controller;

import com.bridgelabz.Mediatorpattern.design.mediater.ChatMediater;
import com.bridgelabz.Mediatorpattern.design.mediater.ChatMediaterImple;
import com.bridgelabz.Mediatorpattern.design.mediater.User;
import com.bridgelabz.Mediatorpattern.design.mediater.UserImple;

public class Runner 
{
public static void main(String[] args) 
{
	ChatMediater mediator = new ChatMediaterImple();
	User user1 = new UserImple(mediator, "Pankaj");
	User user2 = new UserImple(mediator, "Lisa");
	User user3 = new UserImple(mediator, "Saurabh");
	User user4 = new UserImple(mediator, "David");
	mediator.addUser(user1);
	mediator.addUser(user2);
	mediator.addUser(user3);
	mediator.addUser(user4);
	
	user1.send("Hi All");	
}
}
