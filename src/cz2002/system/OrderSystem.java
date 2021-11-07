package cz2002.system;

import cz2002.entity.*;
import java.util.List;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

public class OrderSystem {
	private static ArrayList<Order> orderList;
	private static int orderCount = 0;
	private static Scanner sc = new Scanner(System.in);
	
	private ArrayList<Table> tableList;
	private int tableVacant;
	private boolean isValid = false;
	private final int totalTables = 20;
	
	public static ArrayList<Order> getOrderList() {
		return orderList;
	}
	
	public static void newOrder() {
		
	}
	
	public void printOrderInv() {
		Scanner sc = new Scanner(System.in);
		
		while(!isValid) {
			System.out.println("Enter Order ID to print: ");
			int orderID = sc.nextInt();
			
			for(Order orderP : orderList) {
			    if(orderP.getID() == orderID) {
			    	
			    	
			    	isValid = true;
			    	break;
			    }
			}
			System.out.println("Order ID " + orderID + " not found, please try again");
		}
	}
	
	public static void viewAllOrders() {
		int ori;
		
		if (orderList.size() < 1) {
			System.out.println("\nThere are no orders currently in the system\n");
			return;
		}
		
		ori = 0;
		System.out.println("\n----------------Current Order List----------------");
		for(Order order: orderList) {
			System.out.println("[" + (ori++ + 1) + "] -Order ID: " + order.getID() + " -Created On: " + order.getStart());
			for(MenuItem item: order.getOrderItems()) {
				System.out.println("       --" + item.getName() + " | " + item.getDescription() + " | " + item.getPrice());
			}
		}
	}
	
	public static void viewOrder(int iinput) {
	
		for(Order order: orderList) {
			if(order.getID() == iinput) {
				System.out.println("Order ID: " + order.getID() + " - Created On: " + order.getStart());
				for(MenuItem item: order.getOrderItems()) {
					System.out.println("  --" + item.getName() + " | " + item.getDescription() + " | " + item.getPrice());
				}
				return;
			}
		}
		System.out.println("No order with ID " + iinput + " is found\n");
		
	}
	
	public static void modifyOrder(int uinput) {
		
		boolean finish = true;
		
		for(Order order: orderList) {
			if(order.getID() == uinput) {
				do {
					System.out.println("Order ID: " + order.getID() + " - Created On: " + order.getStart());
					for(MenuItem item: order.getOrderItems()) {
						System.out.println("  --" + item.getName() + " | " + item.getDescription() + " | " + item.getPrice());
					}
					
				} while(finish);
				return;
			}
		}
		System.out.println("No order with ID " + uinput + " is found\n");
		return;
		
	}
	
	public static void removeOrder(int uinput) {
		
		Iterator<Order> it = orderList.iterator();
		
		while (it.hasNext()) {
		  Order order = it.next();
		  if (order.getID().equals(uinput)) {
		    it.remove();
		    return;
		  }
		}

		System.out.println("No order with ID " + uinput + " is found");
		return;
		
	}
}
