package com.crg.rms;

public class Order implements Comparable{
	int itemNumber;
	String itemName;
	double itemCost;
	public Order(int itemNumber, String itemName, double itemCost) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.itemCost = itemCost;
	}
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemCost() {
		return itemCost;
	}
	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return(int) this.itemNumber-((Order)o).itemNumber;
		
	}
	
	

}
