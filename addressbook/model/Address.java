package com.bridgelabz.oops.addressbook.model;

import com.google.gson.annotations.SerializedName;

public class Address {

	private static Address address=null;
	
	private Address() {
		
	}
	
	public static Address getInstance() {
		if(address==null) 
			address = new Address();
		return address;
	}
	
	@SerializedName("doorNo")
	private String doorNo;
	@SerializedName("streetName")
	private String streetName;
	@SerializedName("village")
	private String village;
	/**
	 * @return the doorNo
	 */
	public String getDoorNo() {
		return doorNo;
	}
	/**
	 * @param doorNo the doorNo to set
	 */
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}
	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	/**
	 * @return the city
	 */
	public String getVillage() {
		return village;
	}
	/**
	 * @param city the city to set
	 */
	public void setVillage(String city) {
		this.village = city;
	}
}
