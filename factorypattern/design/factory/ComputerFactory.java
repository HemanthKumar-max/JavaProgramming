package com.bridgelabz.factorypattern.design.factory;

import com.bridgelabz.factorypattern.model.Computer;
import com.bridgelabz.factorypattern.model.Pc;
import com.bridgelabz.factorypattern.model.Server;

public class ComputerFactory 
{
	public static Computer getComputer(String type, String ram, String hdd, String cpu){
		if("PC".equalsIgnoreCase(type)) 
			return new Pc(ram, hdd, cpu);
		else if("Server".equalsIgnoreCase(type)) 
			return new Server(ram, hdd, cpu);
		
		return null;
}
}