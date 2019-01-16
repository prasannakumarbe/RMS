package com.crg.rms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MainClass {
static Restaurant  restaurantObj1;
	static {
		 restaurantObj1=new Restaurant(1111, "AAAA", "BANGALORE");
	
		 restaurantObj1.foodItemList.put(001, new Order(001, "chapathi", 30));
		 restaurantObj1.foodItemList.put(002, new Order(002, "ricebath", 30));
		 restaurantObj1.employeeList.put(101, new Supplier(101, "RAMASH", "Supplier"));
		 restaurantObj1.employeeList.put(102, new Adverties(102, "SEENU", "ADVERTIES","ShowingFood"));
		
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
	System.out.println("CHOOSE OPTION:");
	System.out.println("1.ADMIN\n 2.COUSTOMER\n 3.EXIT");
	int ch=sc.nextInt();
	if(ch==1)
	{
		System.out.println("ENTER USER_NAME:");
		String usrName=sc.next();
		System.out.println("ENTER PASSWORD:");
		String pass=sc.next();
		if(usrName.equalsIgnoreCase("ADMIN") && pass.equals("12345"))
		for(;;)
		{
			System.out.println("1.ADDING_EMPLOYEES\n 2.ADDING_NEW_FOOD_ITEM\n 3.GETTING_ORDERS\n 4.DISPLAY_ALL_EMPLOYEES\n 5.DISPLAY_MENU_LIST");
			int adminCh=sc.nextInt();
			switch(adminCh)
			{
			case 1:restaurantObj1.addingEmployes();//adding employees
			break;
			case 2:restaurantObj1.addingFoodItems();//adding new food items
			break;
			case 3:((Restaurant) restaurantObj1).gettingOrdersFromCoustomers();//getting order from employees
			break;
			case 4:restaurantObj1.displayAllEmployees();//display all employees
			break;
			case 5:restaurantObj1.menuList();//display menuList.
			break;
			default :System.out.println("INVALID OPTION....");
			
			}
		}
		System.out.println("INVALID USER_NAME AND PASSWORD.....");
	}
	else if(ch==2)
	{
		for(;;)
		{
			System.out.println("1.ORDERING ITEMS\n 2.CANCELLING ITEM");
			int chCust=sc.nextInt();
			switch(chCust)
			{
			case 1:restaurantObj1.gettingOrdersFromCoustomers();//ordering items in restaurant
			break;
			case 2:System.out.println("ENTER YOUR ID");
			int custId=sc.nextInt();
			Coustomer custObj=restaurantObj1.coustomerList.get(custId);
			System.out.println("ENTER THE ITEM_NUMBER:");
			int itemNumber=sc.nextInt();
			custObj.cancellingOrder(itemNumber);
			break;
			default:System.out.println("INVALID OPTION.........");
		
			
			}
		}
	}
	System.exit(0);

	}

}
