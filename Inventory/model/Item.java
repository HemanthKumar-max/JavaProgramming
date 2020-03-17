package com.bridgelabz.Inventory.model;

public class Item {
	String name;
	int weight;
	int price;

	public Item() {

	}

	public Item(String name, int weight, int price) {
		super();
		this.name = name;
		this.weight = weight;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	
	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
