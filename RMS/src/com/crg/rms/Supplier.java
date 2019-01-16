package com.crg.rms;

public class Supplier extends Employee {

	public Supplier(int empId, String empName, String jobType) {
		super(empId, empName, jobType);
	
	
	}

	
	public void supplyOrder(Order item,Coustomer coustomer)
	{
		System.out.print(item.itemName+"can be supplied to"+coustomer.coustomerName);
	}
	

}
