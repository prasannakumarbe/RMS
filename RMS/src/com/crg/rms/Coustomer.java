package com.crg.rms;

import java.util.Scanner;

public class Coustomer implements Comparable{
	int coustomerId;
	String coustomerName;
	Scanner sc=new Scanner(System.in);//for reading input from customer
	public Coustomer(int coustomerId, String coustomerName) {
		super();
		this.coustomerId = coustomerId;
		this.coustomerName = coustomerName;
	
	}
	public Coustomer() {
		// TODO Auto-generated constructor stub
	}
	public int getCoustomerId() {
		return coustomerId;
	}
	public void setCoustomerId(int coustomerId) {
		this.coustomerId = coustomerId;
	}
	public String getCoustomerName() {
		return coustomerName;
	}
	public void setCoustomerName(String coustomerName) {
		this.coustomerName = coustomerName;
	}
	
	
	public int orderingFood()
	{
		System.out.println("ENTER THE ITEM_ID:");
		int itemId=sc.nextInt();
		if(!new Restaurant() .foodItemList.containsKey(itemId))
		{
			System.out.println("INVALID ITEM NUMBER...");
		}
		
		return itemId;
		
		
		
	}
	public void havingFood(String foodName)
	{
		System.out.println("I HAVING "+foodName);
	}
	public int payBill()
	{
		System.out.print("ENTER AMOUNT: ");
		return sc.nextInt();
	}
	void cancellingOrder(int itemNumber)
	{
		new Restaurant() .foodItemList.remove(itemNumber);
	}
	@Override
	public int compareTo(Object o) {
		
		return(int) this.coustomerId-((Coustomer)o).coustomerId;
	}

}
