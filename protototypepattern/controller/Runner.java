package com.bridgelabz.protototypepattern.controller;

import java.util.List;

import com.bridgelabz.protototypepattern.model.EmployeeModel;

public class Runner 
{
	public static void main(String[] args) throws CloneNotSupportedException 
	{
		EmployeeModel emp=new EmployeeModel();
		System.out.println("=======EmployeeNameDetails=======");
		emp.addDetails();
		System.out.println(emp.getEmplist());
		System.out.println("===============================");
		
		System.out.println("==========clonedObjects===========");
		EmployeeModel newemp1=(EmployeeModel)emp.clone();
		EmployeeModel newemp2=(EmployeeModel)emp.clone();
		System.out.println("newemp1="+newemp1.getEmplist());
		System.out.println("newemp2="+newemp2.getEmplist());
		System.out.println("==================================");
		
		System.out.println("========Again adding method for cloned objects=======");
		List<String> emplist1=newemp1.getEmplist();
		emplist1.add("harshadRokade");
		System.out.println(emplist1);
		System.out.println("==============================================");
	    
		
        	   	
		
		
	}

}
