package com.bridgelabz.oops.addressbook.repository;

public interface AddressBookService {

	public void createNewAddressBook(String fileName);

	public void openAddressBook(String fileName);

	public void saveAddressBook();

	public void saveAsAddressBook();

	public void quit();

	public void addPerson();

	public void editPerson(long mobileNo);

	public void deletePerson(long mobileNo);

	public void sortEntriesByName();

	public void sortEntriesByZip();

	public void printEntries();
}
