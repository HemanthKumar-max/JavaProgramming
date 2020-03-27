package com.bridgelabz.crud.controller;

import com.bridgelabz.crud.Serviceprovider.StudentService;
import com.bridgelabz.crud.Utils.InputUtility;
import com.bridgelabz.crud.repository.StudentRepo;

public class Runner {

	static StudentRepo strp = new StudentRepo();
	static StudentService stser = strp.factoryclass();

	public static void main(String[] args) {
		Runner.studentMenu();
	}

	public static void studentMenu() {
		System.out.println("===============================");
		System.out.println("1:--> to addDetails of student");
		System.out.println("2:-->to getDetails of student");
		System.out.println("3:-->to update details of student");
		System.out.println("4:-->to delete details of student");
		System.out.println("5:-->Search the names");
		System.out.println("6:--->list of Ages, greater than average age");
		System.out.println("7:--->list of marks , scored above 50 ");
		System.out.println("==================================");
		int choice = InputUtility.nextInt();
		Runner.studentMenuController(choice);
	}

	public static void studentMenuController(int choice) {
		switch (choice) {

		case 1:
			stser.addDetails();
			break;
		case 2:
			System.out.println("enter the name to get details");
			String sername = InputUtility.next();
			stser.getDetails(sername);
			break;
		case 3:
			System.out.println("enter the name that has to be updated");
			String updname = InputUtility.next();
			System.out.println("enter the appropriate age of a person");
			int updage = InputUtility.nextInt();
			stser.updateDetails(updname, updage);
			break;
		case 4:
			System.out.println("enter the name that has to be deleted");
			String dname = InputUtility.next();
			System.out.println("enter the appropriate age of a person");
			int dage = InputUtility.nextInt();
			stser.deleteDetails(dname, dage);
			break;

		case 5:
			System.out.println("enter the name that has to be searched");
			String sname = InputUtility.next();
			stser.searchDetails(sname);
			break;
		case 6:
			stser.greaterthanAverageAge();
			break;
		case 7:
			stser.marksNotGreaterthan50();
			break;
		}
	}
}