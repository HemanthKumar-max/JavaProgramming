package com.bridgelabz.inventorymanager.model;

public class InventoryFactory {
	String brandName;
	int costPrice;
	int netWeight;
	public InventoryFactory() {

	}
	public InventoryFactory(String brandName, int costPrice, int netWeight) {
		super();
		this.brandName = brandName;
		this.costPrice = costPrice;
		this.netWeight = netWeight;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(int costPrice) {
		this.costPrice = costPrice;
	}
	public int getNetWeight() {
		return netWeight;
	}
	public void setNetWeight(int netWeight) {
		this.netWeight = netWeight;
	}
	

	
}
