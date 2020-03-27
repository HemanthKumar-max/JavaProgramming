package com.bridgelabz.Mediatorpattern.design.mediater;

import java.util.ArrayList;
import java.util.List;

public class ChatMediaterImple implements ChatMediater {

	private List<User> users;

	public ChatMediaterImple() {
		super();
		this.users = new ArrayList<>();
	}

	@Override
	public void sendMessage(String msg, User user) {
		for (User u : this.users) {
			// message should not be received by the user sending it
			if (u != user) {
				u.receive(msg);
			}
		}
	}

	@Override
	public void addUser(User user) {
		this.users.add(user);

	}

}
