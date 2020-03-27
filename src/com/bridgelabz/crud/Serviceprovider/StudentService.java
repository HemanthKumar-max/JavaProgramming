package com.bridgelabz.crud.Serviceprovider;



public interface StudentService {
	
	public void addDetails();

	public void getDetails(String name);

	public void updateDetails(String name, int age);

	public void deleteDetails(String name,int age);
	
    public void searchDetails(String name);
    
    public void greaterthanAverageAge();
    
    public void marksNotGreaterthan50();
    

}
