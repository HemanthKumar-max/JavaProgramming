package com.bridgelabz.proxypattern.design.proxy;

public class ComputerExecuterImple implements CommandExecuter
{

	@Override
	public void runComand(String command) throws Exception {
		Runtime.getRuntime().exec(command);
		System.out.println(" "  +command+"command Excuted");
	}

}
