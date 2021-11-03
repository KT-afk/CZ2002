package cz2002.system;

import cz2002.entity.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

public class OrderSystem {
	private ArrayList<Order> orderList;
	private ArrayList<Table> tableList;
	private int tableVacant;
	private boolean isValid = false;
	private int orderCount = 0;
	private final int totalTables = 20;
	
	public void newOrder() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Select type of order (1 or 2)");
		System.out.println("--------------------");
		System.out.println("(1) From reservation");
		System.out.println("(2) From walk-in order");
		int orderType = sc.nextInt();
		
		switch(orderType) {
			case 1:
				System.out.println("Enter reservation ID: ");
				break;
			case 2:
				System.out.println("Enter staff name: ");
				String staffin = sc.nextLine();
				break;
			default:
				System.out.println("Option entered is invalid, please try again");
		}
		
		
		System.out.println("Order no. " + orderCount + 1 + "");
		orderCount+=1;
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
	
	public void getTableVacant() {
		int noVacant = totalTables - tableVacant;
		System.out.println("No. of tables left: " + noVacant);
		System.out.printf("Table no. available: ");
		for(Table tableP : tableList) {
		    if(tableP.getStatus() == "vacant") {
//		    	System.out.printf("%d, ", tableP.getTableno());
		    }
		}
	}
}
