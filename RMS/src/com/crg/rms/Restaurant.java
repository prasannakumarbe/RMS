/*
 * This class is used for managing all Restaurant functionalites.. like adding new employees,adding new foods and getting orders from coustomers...
 */

package com.crg.rms;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Restaurant {
	int restaurantNumber;
	String restaurantName;
	String restaurentAddrs;
	Scanner sc = new Scanner(System.in);
	/* fooditem database */
	static TreeMap<Integer, Order> foodItemList = new TreeMap<Integer, Order>();
	/* coustomer database */
	static TreeMap<Integer, Coustomer> coustomerList = new TreeMap<Integer, Coustomer>();
	/* Employees database */
	static TreeMap<Integer, Employee> employeeList = new TreeMap<Integer, Employee>();
	static JFrame frame = new JFrame("Error Msgs");/* For error pop up msg box */
	Random rand = new Random();

	int randomIds = rand.nextInt(50) + 1;

	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant(int restaurantNumber, String restaurantName, String restaurentAddrs) {
		super();
		this.restaurantNumber = restaurantNumber;
		this.restaurantName = restaurantName;
		this.restaurentAddrs = restaurentAddrs;
	}

	public int getRestaurantNumber() {
		return restaurantNumber;
	}

	public void setRestaurantNumber(int restaurantNumber) {
		this.restaurantNumber = restaurantNumber;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurentAddrs() {
		return restaurentAddrs;
	}

	public void setRestaurentAddrs(String restaurentAddrs) {
		this.restaurentAddrs = restaurentAddrs;
	}

	/* this for adding new workers into the restaurant */
	public void addingEmployes() {
		Employee orderObj = new Employee();// creating employee object for calling getter and setter methods of that
											// class..
		System.out.println("ENTER YOUR NAME:");
		String empName=sc.next();
		
		while (!(Pattern.matches("[a-zA-Z0-9]{6}", empName ))) {
			String st2 = "Employee name can only contain alphanumeric characters and length should be minimum 6 characters";
			JOptionPane.showMessageDialog(frame, st2);
			empName=sc.next();

		}

		System.out.println("ENTER THE JOBTYPE:");
		orderObj.setJobType(sc.next());

		String jobType = orderObj.getJobType();
		new Restaurant().employeeList.put(randomIds, new Employee(randomIds, empName, jobType));
	}

	/* This for adding new food */
	public void addingFoodItems() {

		Random rand = new Random();// generating random numbers..
		Order orderObj = new Order();// creating order object for calling getter and setter methods of that class..
		int randomIds = rand.nextInt(50) + 1;
		System.out.println("ENTER ITEM NAME:");
		orderObj.setItemName(sc.next());
		String itemName;
		while (!(Pattern.matches("[a-zA-Z0-9]{6}", itemName = orderObj.getItemName()))) {
			String st2 = "Item Name contains only charectors..";
			JOptionPane.showMessageDialog(frame, st2);
			orderObj.setItemName(sc.next());
			itemName = orderObj.getItemName();

		}

		System.out.println("ENTER COST OF ITEM");
		
		String itemCost=sc.next();
		while (!(Pattern.matches("[0-9]+", itemCost))) {
			String st2 = "ID contains only Numbers..";
			JOptionPane.showMessageDialog(frame, st2);
			itemCost = sc.next();

		}
		new Restaurant().foodItemList.put(randomIds, new Order(randomIds, itemName, Integer.parseInt(itemCost)));// putting new food item
																								// into foodItemList...
	}

	/* Getting orders from coustomers */
	public void gettingOrdersFromCoustomers() {

		new Restaurant().menuList();// calling menulist method to display all items..
		System.out.println("CHOOSE ITEM:");
		System.out.println("******************");

		Order item = foodItemList.get(new Coustomer().orderingFood());// getting item from coustomers

		System.out.println("ENTER YOUR ID:");
		String coustomerId = sc.next();
		while (!(Pattern.matches("[0-9]+", coustomerId))) {
			String st2 = "ID contains only Numbers..";
			JOptionPane.showMessageDialog(frame, st2);
			coustomerId = sc.next();

		}
		System.out.println("ENTER YOUR NAME:");
		String coustomerName = sc.next();
		while (!(Pattern.matches("[a-zA-Z0-9]{6}", coustomerName))) {
			String st2 = "Coustomer name can only contain alphanumeric characters and hypehns(-)";
			JOptionPane.showMessageDialog(frame, st2);
			coustomerName = sc.next();

		}
		System.out.println("ENTE NUMBER OF QUANTITY:");
		String quantity = sc.next();
		while (!(Pattern.matches("[0-9]+", quantity))) {
			String st2 = "Quantity contains only Numbers..";
			JOptionPane.showMessageDialog(frame, st2);
			quantity = sc.next();

		}
		new Restaurant().coustomerList.put(Integer.parseInt(coustomerId),
				new Coustomer(Integer.parseInt(coustomerId), coustomerName));// adding coustomer
		// object into map

		new Restaurant().providing(item, coustomerList.get(coustomerId));// calling providing() method for providing
																			// food to coustomer..
		new Restaurant().genratingBill(Integer.parseInt(quantity), Integer.parseInt(coustomerId), item);// calling
																										// genratingBill()
																										// method for
																										// genrating
																										// bill
		// to coustomer...

	}

	/* Genrating bill */
	public void genratingBill(int quantity, int coustomerId, Order item) {
		System.out.println("\t\t\tAAAA\t");
		System.out.println("********************************");
		System.out.println("ITEM_NAME:" + item.itemName);
		System.out.println("YOUR ID:" + coustomerId);
		System.out.println("\t\t\tTOTAL:" + quantity + "*" + item.itemCost + "=" + quantity * item.itemCost);
		System.out.println("THANKS..................");
		System.out.println("************************************");
	}

	/* display all employees */
	public void displayAllEmployees() {
		System.out.println("EMP_ID:\t\t EMP_NAME:\t\t JOB_TYPE:");
		System.out.println("***********************************************");
		Set empkeys = Restaurant.employeeList.keySet();
		Iterator empls = empkeys.iterator();
		while (empls.hasNext()) {
			Employee emplsobj = Restaurant.employeeList.get(empls.next());
			System.out.println(emplsobj.empId + "\t\t" + emplsobj.empName + "\t\t" + emplsobj.jobType);
		}

	}

	/* display menuList */
	public void menuList() {
		System.out.println("ITEM_NO:\t\t ITEM_NAME:\t\t COST:");
		System.out.println("***********************************************");
		Set itemKeys = Restaurant.foodItemList.keySet();
		Iterator items = itemKeys.iterator();
		while (items.hasNext()) {
			Order fooditems = Restaurant.foodItemList.get(items.next());
			System.out.println(fooditems.itemNumber + "\t\t" + fooditems.itemName + "\t\t" + fooditems.itemCost);
		}
	}

	/* assigning supplier to coustomer order to supplying food */
	public void providing(Order item, Coustomer coustomer) {
		Set empkeys = Restaurant.employeeList.keySet();
		Iterator empls = empkeys.iterator();
		while (empls.hasNext()) {
			Employee empObj = (Employee) employeeList.get(empls.next());
			if (empObj instanceof Supplier && empObj.empId == randomIds) {
				Supplier supObj = (Supplier) empObj;
				supObj.supplyOrder(item, coustomer);// admin call the supplyer to supply the food to coustomer
			}
		}

	}

}
