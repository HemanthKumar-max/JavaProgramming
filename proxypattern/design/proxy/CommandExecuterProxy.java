package com.bridgelabz.proxypattern.design.proxy;

public class CommandExecuterProxy implements  CommandExecuter 
{
private boolean isAdmin;
private CommandExecuter excecuter;
public CommandExecuterProxy(String user,String password)
{
	if("hemanth".equals(user) && "jackie".equals(password)) isAdmin=true;
	excecuter = new ComputerExecuterImple();
	
	
	
	
}
@Override
public void runComand(String command) throws Exception {
	if(isAdmin)
	{
		excecuter.runComand(command);
	}
	else
	{
		if(command.startsWith("rm"))
		{
			throw new Exception("rm command is not allowed for non admin users");
		}
		else
		{
			excecuter.runComand(command);
		}
	}
	
}
}



