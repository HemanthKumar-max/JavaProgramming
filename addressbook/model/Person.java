package com.bridgelabz.oops.addressbook.model;

import com.bridgelabz.userdefinedexception.CustomizedException;
import com.google.gson.annotations.SerializedName;

public class Person {

	private static Person person = null;

	private Person() {

	}

	public static Person getInstance() {
		if (person == null)
			person = new Person();
		return person;
	}

	@SerializedName("firstName")
	private String firstName;
	@SerializedName("lastName")
	private String lastName;
	@SerializedName("address")
	private Address address;
	@SerializedName("city")
	private String city;
	@SerializedName("state")
	private String state;
	@SerializedName("zip")
	private int zip;
	@SerializedName("phoneNumber")
	private long phoneNumber;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 * @throws CustomizedException
	 */
	public void setZip(int zip) throws CustomizedException {
		String temp = "" + zip;
		if (temp.length() == 6) {
			this.zip = zip;
			return;
		}
		throw new CustomizedException("zip length should be of 6 digits");
	}

	/**
	 * @return the phoneNumber
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 * @throws CustomizedException
	 */
	public void setPhoneNumber(long phoneNumber) throws CustomizedException {
		String temp = "" + phoneNumber;
		if (temp.length() == 10) {
			this.phoneNumber = phoneNumber;
			return;
		}
		throw new CustomizedException("Phone Number should be of 10 digits");
	}
}
