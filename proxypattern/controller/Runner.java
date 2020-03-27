package com.bridgelabz.proxypattern.controller;

import com.bridgelabz.proxypattern.design.proxy.CommandExecuter;
import com.bridgelabz.proxypattern.design.proxy.CommandExecuterProxy;

public class Runner {
	public static void main(String[] args) {
		CommandExecuter executer = new CommandExecuterProxy("hemanth", "sdfgh");
		try {
			executer.runComand("ls -ltr");
			executer.runComand(" rm -rf abc.pdf");
		} catch (Exception e) {
			System.out.println("Exception Message::" + e.getMessage());
		}

	}
}
