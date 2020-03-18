package com.bridgelabz.oops.addressbook.controller;
/**
 * @author:Hemanth Kumar
 * @date: 2020/03/17
 * @version:1.2
 * Purpose:  The software to be designed is a program that can be used to maintain an address book. An address book
       holds a collection of entries, each recording a person's first and last names, address, city, state, zip, and
        phone number.
 **/

/**
 * Here import the utility package to use the Utility class in a program.
 **/
import com.bridgelabz.oops.addressbook.repository.AddressBookService;
import com.bridgelabz.oops.addressbook.utils.InputUtility;
import com.bridgelabz.oops.addressbook.utils.Utility;

public class Runner {

	/**
	 * main method to run the AddressBook
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		AddressBookService service = Utility.getServiceObject();
		int choice;
		String option;
		String fileName;
		do {

			System.out.println("---------Address Book File Menu----------");
			System.out.println("1. Create New AddresBook");
			System.out.println("2. Open AddressBook");
			System.out.println("3. Close AddresBook");
			System.out.println("4. SaveAs AddresBook");
			System.out.println("5. To Save And quit AddressBook");

			choice = InputUtility.readInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Name of the AddressBook :");
				fileName = InputUtility.readString() + ".json";
				service.createNewAddressBook(fileName);
				break;
			case 2:
				System.out.println("Enter  Name of the AddressBook :");
				fileName = InputUtility.readString() + ".json";
				service.openAddressBook(fileName);
				break;
			case 3:
				System.out.println("Thank you!!!");
				System.exit(0);
				break;
			case 4:
				service.saveAsAddressBook();
				break;
			case 5:
				service.quit();
				System.exit(0);
				break;
			default:
				System.out.println("Wrong Choice");
			}
			System.out.println("Would You like To Continue in File Menu (yes/no) ? :");
			option = InputUtility.readString();
		} while (option.equalsIgnoreCase("yes"));
		System.out.println("Exited From AddresBook File Menu");
	}
}
