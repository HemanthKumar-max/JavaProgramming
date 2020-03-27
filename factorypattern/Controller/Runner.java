package com.bridgelabz.factorypattern.Controller;

import com.bridgelabz.factorypattern.design.factory.ComputerFactory;
import com.bridgelabz.factorypattern.model.Computer;

public class Runner 
{

	public static void main(String[] args) {
            Computer pc = ComputerFactory.getComputer("pc","2 GB","500 GB","2.4 GHz");
			Computer server = ComputerFactory.getComputer("server","16 GB","1 TB","2.9 GHz");
			System.out.println("Factory PC Configuration::"+pc);
			System.out.println("Factory Server Configuration::"+server);
		}
	

}
