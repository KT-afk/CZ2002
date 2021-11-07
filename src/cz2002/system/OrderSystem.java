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
	private static ArrayList<Order> orderList = new ArrayList<Order>();
	private static int orderCount = 0;
	
	private boolean isValid = false;
	
	public static ArrayList<Order> getOrderList() {
		return orderList;
	}
	
	public static void addOrder(Order order) {
		orderList.add(order);
		orderCount++;
		System.out.println("\nOrder " + orderCount + " Successfully Created");
		System.out.println("=================== Order " + orderCount + " ===================");
		System.out.println("Order Items: ");
		if (order.getDishItems().size() < 1) {
			System.out.println("    <No Item>");
		}
		for(int i=0;i<order.getDishItems().size();i++) {
			System.out.println("   --" + order.getDishItems().get(i).getName() + " $" + order.getDishItems().get(i).getPrice());
		}
		System.out.println("Set Packages: ");
		if (order.getPackItems().size() < 1) {
			System.out.println("    <No Package>");
		}
		for(int i=0;i<order.getPackItems().size();i++) {
			System.out.println("   --" + order.getPackItems().get(i).getName() + " $" + order.getPackItems().get(i).getPrice());
		}
		System.out.println("Order created on " + order.getStart());
		System.out.println("==============================================");
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
			for(MenuItem item: order.getDishItems()) {
				System.out.println("       --" + item.getName() + " | " + item.getDescription() + " | " + item.getPrice());
			}
			for(MenuItem item: order.getPackItems()) {
				System.out.println("       --" + item.getName() + " | " + item.getDescription() + " | " + item.getPrice());
			}
		}
	}
	
	public static void viewOrder(int iinput) {
	
		for(Order order: orderList) {
			if(order.getID() == iinput) {
				System.out.println("Order ID: " + order.getID() + " - Created On: " + order.getStart());
				for(FoodDish fditem: order.getDishItems()) {
					System.out.println("  --" + fditem.getName() + " | " + fditem.getDescription() + " | " + fditem.getPrice());
				}
				for(SetPackage pitem: order.getPackItems()) {
					System.out.println("  --" + pitem.getName() + " | " + pitem.getDescription() + " | " + pitem.getPrice());
				}
				return;
			}
		}
		System.out.println("No order with ID " + iinput + " is found\n");
		
	}
	
	public static void modifyOrder(int uinput, RestaurantMenu RestaurantMenu) {
		
		Scanner sc = new Scanner(System.in);
		
		int ucho, uadd;
		String iname, desc;
		double price;
		
		for(Order order: orderList) {
			if(order.getID() == uinput) {
				System.out.println("=================== Order " + order.getID() + " ===================");
				System.out.println("Order Items: ");
				for(int i=0;i<order.getDishItems().size();i++) {
					System.out.println("   --" + order.getDishItems().get(i).getName() + " $" + order.getDishItems().get(i).getPrice());
				}
				System.out.println("Set Packages: ");
				for(int i=0;i<order.getPackItems().size();i++) {
					System.out.println("   --" + order.getPackItems().get(i).getName() + " $" + order.getPackItems().get(i).getPrice());
				}
				System.out.println("Total Cost: $" + order.totalPrice() );
				System.out.println("Order created on " + order.getStart());
				System.out.println("==============================================");
				
				do {
					System.out.println("Select one of the options: ");
					System.out.println("1) Add menu item");
					System.out.println("2) Add set package");
					System.out.println("3) Remove menu item");
					System.out.println("4) Remove set package");
					
					ucho = sc.nextInt();
					
					switch(ucho) {
					case 1:
						System.out.println("For packages in the menu");
						for (int i = 0; i < RestaurantMenu.setPackageMenu.size(); i++) {
							iname = RestaurantMenu.setPackageMenu.get(i).getName();
							desc = RestaurantMenu.setPackageMenu.get(i).getDescription();
							price = RestaurantMenu.setPackageMenu.get(i).getPrice();
							System.out.println((i + 1) + ") " + iname + " | " + desc + " | " + price);
						}
						do {
							System.out.println("Choose packages to add into order");
							System.out.println("Enter -1 to stop");
							uadd = sc.nextInt();

							if (uadd == -1) {
								break;
							}

							if (uadd <= RestaurantMenu.setPackageMenu.size()) {
								order.addPackItem(new SetPackage(RestaurantMenu.setPackageMenu.get(uadd - 1).getName(),
										RestaurantMenu.setPackageMenu.get(uadd - 1).getDescription(),
										RestaurantMenu.setPackageMenu.get(uadd - 1).getPrice()));
							} 
							else {
								System.out.println("Choice is invalid");
							}

						} while (true);
					case 2:
						System.out.println("For menu items in the menu");
						for (int i = 0; i < RestaurantMenu.alaCarteMenu.size(); i++) {
							iname = RestaurantMenu.alaCarteMenu.get(i).getName();
							desc = RestaurantMenu.alaCarteMenu.get(i).getDescription();
							price = RestaurantMenu.alaCarteMenu.get(i).getPrice();
							System.out.println((i + 1) + ") " + iname + " | " + desc + " | " + price);
						}
						do {
							System.out.println("Choose menu items to add into order");
							System.out.println("Enter -1 to stop");
							uadd = sc.nextInt();

							if (uadd == -1) {
								break;
							}

							if (uadd <= RestaurantMenu.alaCarteMenu.size()) {
								order.addDishItem(new FoodDish(RestaurantMenu.alaCarteMenu.get(uadd - 1).getName(),
										RestaurantMenu.alaCarteMenu.get(uadd - 1).getDescription(),
										RestaurantMenu.alaCarteMenu.get(uadd - 1).getPrice(),
										RestaurantMenu.alaCarteMenu.get(uadd - 1).getType()));
							} 
							else {
								System.out.println("Choice is invalid");
							}

						} while (true);
					case 3:
						do {
							System.out.println("Order Items: ");
							if (order.getDishItems().size() < 1) {
								System.out.println("  --No Item Left");
								break;
							}
							for(int i=0;i<order.getDishItems().size();i++) {
								System.out.println((i+1) + ") " + order.getDishItems().get(i).getName() + " $" + order.getDishItems().get(i).getPrice());
							}
						
							System.out.println("Choose menu items to remove from order");
							System.out.println("Enter -1 to stop");
							uadd = sc.nextInt();

							if (uadd == -1) {
								break;
							}

							if (uadd <= order.getDishItems().size()) {
								order.getDishItems().remove(uadd-1);
							} 
							else if (uadd == 0 || uadd > order.getDishItems().size()){
								System.out.println("Choice is invalid");
							}

						} while (true);
					case 4:
						do {
							System.out.println("Set Packages: ");
							if (order.getPackItems().size() < 1) {
								System.out.println("  --No Item Left");
								break;
							}
							for(int i=0;i<order.getPackItems().size();i++) {
								System.out.println((i+1) + ") " + order.getPackItems().get(i).getName() + " $" + order.getPackItems().get(i).getPrice());
							}
						
							System.out.println("Choose set packages to remove from order");
							System.out.println("Enter -1 to stop");
							uadd = sc.nextInt();

							if (uadd == -1) {
								break;
							}

							if (uadd <= order.getPackItems().size()) {
								order.getPackItems().remove(uadd-1);
							} 
							else if (uadd == 0 || uadd > order.getPackItems().size()){
								System.out.println("Choice is invalid");
							}

						} while (true);
					}
					
				} while(true);
				
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
	
	public static void completeOrder(int uinput, double discountamt) {
		
		double discount = 1 * discountamt;
		Iterator<Order> it = orderList.iterator();
		
		while (it.hasNext()) {
		  Order order = it.next();
		  if (order.getID().equals(uinput)) {
			System.out.println("=================== Order " + order.getID() + " ===================");
			System.out.println("Order Items: ");
			for(int i=0;i<order.getDishItems().size();i++) {
				System.out.println("   --" + order.getDishItems().get(i).getName() + " $" + order.getDishItems().get(i).getPrice());
			}
			System.out.println("Set Packages: ");
			for(int i=0;i<order.getPackItems().size();i++) {
				System.out.println("   --" + order.getPackItems().get(i).getName() + " $" + order.getPackItems().get(i).getPrice());
			}
			System.out.println("Total Cost: $" + order.totalPrice()*discount );
			System.out.println("Order created on " + order.getStart());
			System.out.println("==============================================");
			it.remove();
			return;
		  }
		}

		System.out.println("No order with ID " + uinput + " is found");
		return;
		
	}
}
