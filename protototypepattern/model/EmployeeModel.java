package com.bridgelabz.protototypepattern.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeModel implements Cloneable
{
private List<String> emplist=new ArrayList<>();

public EmployeeModel(List<String> emplist) {
	super();
	this.emplist = emplist;
}
public EmployeeModel()
{
	
}





public void addDetails()
{
	emplist.add("ram");
	emplist.add("hemanth");
	emplist.add("ramya");
	emplist.add("Bharath");
}



public List<String> getEmplist() {
	return emplist;
}
public void setEmplist(List<String> emplist) {
	this.emplist = emplist;
}

public Object clone() throws CloneNotSupportedException
{
	List<String> al=new ArrayList<>();
	for(String s:this.getEmplist())
	{
	al.add(s);	
    }
	return new EmployeeModel(al);
}


}
