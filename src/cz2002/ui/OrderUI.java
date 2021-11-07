package cz2002.ui;
import cz2002.entity.*;
import cz2002.entity.Person.Gender;
import cz2002.system.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import cz2002.SystemClock;

public class OrderUI {
	
	private Scanner sc;
	private ReservationSystem ReservationSystem;
	private TableSystem TableSystem;
	private RestaurantMenu RestaurantMenu;

	public OrderUI(Scanner scanner, ReservationSystem ReservationSystem, TableSystem TableSystem, RestaurantMenu RestaurantMenu) {
		sc = scanner;
		this.ReservationSystem = ReservationSystem;
		this.TableSystem = TableSystem;
		this.RestaurantMenu = RestaurantMenu;
	}
	
	public void manageOrders (List<Table> tables) {
		int uchoice;
		do {
			System.out.println("-----------ORDER OPTIONS-----------");
			uchoice = Prompt(sc,
							"View Current Orders",
							"View Order by ID",
							"New Orders",
							"Modify Existing Orders",
							"Remove Orders",
							"Complete Order",
							"Return to Main Menu"
						);
			
			switch(uchoice) {
				case 1:
					OrderSystem.viewAllOrders();
					break;
				case 2:
					viewOrder();
					break;
				case 3:
					newOrder(tables);
					break;
				case 4:
					modifyOrders();
					break;
				case 5:
					removeOrders();
					break;
				case 6:
					//Prints Order Invoice
					completeOrder();
					break;
				case 7:
					return;
			}
		}while (true);
	}

	public void printOrderInvoice() {

	}
	
	private void viewOrder() {
		System.out.println("\nType in the order ID for viewing: ");
		int iinput = sc.nextInt();
		OrderSystem.viewOrder(iinput);
	}
	
	private void newOrder(List<Table> tables) {
		int orderType, uadd;
		String staffin, staffpos, staffgen;
		String iname, desc;
		double price;
		Gender gender;
		ReservationSystem reservationSystem = new ReservationSystem(tables);
		
		ArrayList<FoodDish> orDish = new ArrayList<FoodDish>();
		ArrayList<SetPackage> orPack = new ArrayList<SetPackage>();

		do {
			
			System.out.println("Select type of order (1 or 2)");
			System.out.println("-----------------------------");
			System.out.println("1) From reservation");
			System.out.println("2) From walk-in order");
			orderType = sc.nextInt();
			
			System.out.println("Enter staff name: ");
			staffin = sc.next();
			
			System.out.println("Enter staff title: ");
			staffpos = sc.next();
			
			System.out.println("Enter staff gender(m/f): ");
			staffgen = sc.next();
			
			gender = (staffgen == "m") ? Gender.Male : Gender.Female;
			
			Staff orStaff = new Staff(staffin, gender, staffpos);
			
			switch(orderType) {
				case 1:
					System.out.println("Enter reservation ID: ");
					String resId = sc.next();
					Reservation resv = reservationSystem.getReservation(resId);
					
					ReservationSystem.reservationArrival(resId);
					
					Table orTable = TableSystem.getTableByNo(resv.getTableNo());
					
					System.out.println("For packages in the menu");
					for(int i=0;i<RestaurantMenu.setPackageMenu.size();i++) {
						iname = RestaurantMenu.setPackageMenu.get(i).getName();
						desc = RestaurantMenu.setPackageMenu.get(i).getDescription();
						price = RestaurantMenu.setPackageMenu.get(i).getPrice();
						System.out.println((i+1) + ") " + iname + " | " + desc + " | " + price);
					}
					do {
						System.out.println("Choose packages to add into order");
						System.out.println("Enter -1 to stop");
						uadd = sc.nextInt();
						
						if(uadd == -1) {
							break;
						}
						
						if(uadd <= RestaurantMenu.setPackageMenu.size()) {
							orPack.add(new SetPackage(RestaurantMenu.setPackageMenu.get(uadd-1).getName(), RestaurantMenu.setPackageMenu.get(uadd-1).getDescription(), RestaurantMenu.setPackageMenu.get(uadd-1).getPrice()));
						}
						else {
							System.out.println("Choice is invalid");
						}
						
					} while (true);
					
					System.out.println("For menu items in the menu");
					for(int i=0;i<RestaurantMenu.alaCarteMenu.size();i++) {
						iname = RestaurantMenu.alaCarteMenu.get(i).getName();
						desc = RestaurantMenu.alaCarteMenu.get(i).getDescription();
						price = RestaurantMenu.alaCarteMenu.get(i).getPrice();
						System.out.println((i+1) + ") " + iname + " | " + desc + " | " + price);
					}
					do {
						System.out.println("Choose menu items to add into order");
						System.out.println("Enter -1 to stop");
						uadd = sc.nextInt();
						
						if(uadd == -1) {
							break;
						}
						
						if(uadd <= RestaurantMenu.alaCarteMenu.size()) {
							orDish.add(new FoodDish(RestaurantMenu.alaCarteMenu.get(uadd-1).getName(), RestaurantMenu.alaCarteMenu.get(uadd-1).getDescription(), RestaurantMenu.alaCarteMenu.get(uadd-1).getPrice(), RestaurantMenu.alaCarteMenu.get(uadd-1).getType()));
						}
						else {
							System.out.println("Choice is invalid");
						}
						
					} while (true);
					
					
					Order newOrder = new Order(orStaff, orDish, orPack, resv, orTable, LocalDateTime.now());
							
					OrderSystem.addOrder(newOrder);
					
					break;
				case 2:
					System.out.println("For packages in the menu");
					for(int i=0;i<RestaurantMenu.setPackageMenu.size();i++) {
						iname = RestaurantMenu.setPackageMenu.get(i).getName();
						desc = RestaurantMenu.setPackageMenu.get(i).getDescription();
						price = RestaurantMenu.setPackageMenu.get(i).getPrice();
						System.out.println((i+1) + ") " + iname + " | " + desc + " | " + price);
					}
					do {
						System.out.println("Choose packages to add into order");
						System.out.println("Enter -1 to stop");
						uadd = sc.nextInt();
						
						if(uadd == -1) {
							break;
						}
						
						if(uadd <= RestaurantMenu.setPackageMenu.size()) {
							orPack.add(new SetPackage(RestaurantMenu.setPackageMenu.get(uadd-1).getName(), RestaurantMenu.setPackageMenu.get(uadd-1).getDescription(), RestaurantMenu.setPackageMenu.get(uadd-1).getPrice()));
						}
						else {
							System.out.println("Choice is invalid");
						}
						
					} while (true);
					
					System.out.println("For menu items in the menu");
					for(int i=0;i<RestaurantMenu.alaCarteMenu.size();i++) {
						iname = RestaurantMenu.alaCarteMenu.get(i).getName();
						desc = RestaurantMenu.alaCarteMenu.get(i).getDescription();
						price = RestaurantMenu.alaCarteMenu.get(i).getPrice();
						System.out.println((i+1) + ") " + iname + " | " + desc + " | " + price);
					}
					do {
						System.out.println("Choose menu items to add into order");
						System.out.println("Enter -1 to stop");
						uadd = sc.nextInt();
						
						if(uadd == -1) {
							break;
						}
						
						if(uadd <= RestaurantMenu.alaCarteMenu.size()) {
							orDish.add(new FoodDish(RestaurantMenu.alaCarteMenu.get(uadd-1).getName(), RestaurantMenu.alaCarteMenu.get(uadd-1).getDescription(), RestaurantMenu.alaCarteMenu.get(uadd-1).getPrice(), RestaurantMenu.alaCarteMenu.get(uadd-1).getType()));
						}
						else {
							System.out.println("Choice is invalid");
						}
						
					} while (true);
					
					ArrayList<Table> availTable = TableSystem.checkAvailability();
					
					for(int i=0;i<availTable.size();i++) {
						
					}
					
					Order newOrder2 = new Order(orStaff, orDish, orPack, null, orTable, LocalDateTime.now());
							
					OrderSystem.addOrder(newOrder2);
					
					
					break;
				default:
					System.out.println("Option entered is invalid, please try again\n");
			}
		} while(true);
		
	}
	
	private void modifyOrders() {
		int uc;
		do {
			System.out.println("\nType in the order ID to modify: ");
			int uinput = sc.nextInt();
			OrderSystem.modifyOrder(uinput);
			
			uc = Prompt(sc,
					"Modify Another Orders",
					"End Modification"
				);
			if(uc == 2) {
				return;
			}
		} while (true);
	}
	
	private void removeOrders() {
		int uc;
		do {
			System.out.println("\nType in the order ID to remove from system: ");
			int uinput = sc.nextInt();
			OrderSystem.removeOrder(uinput);
			
			
			uc = Prompt(sc,
					"Remove Another Orders",
					"End Removal"
				);
			if(uc == 2) {
				return;
			}
		} while (true);
	}
	
	private void completeOrder() {
		
	}



	// Utility Functions
	private static int Prompt(Scanner scanner, String... options) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println();
		System.out.printf("The current time is %s\n", SystemClock.GetCurrentDateTime().format(formatter));
		System.out.println("Please select one of the following options: ");
		for(int i = 1; i <= options.length; i++)
			System.out.printf("%d) %s\n", i, options[i-1]);
		System.out.print("> ");

		try {
			int option = scanner.nextInt();
			if(option > options.length)
				throw new Exception();

			scanner.nextLine();
			return option;
		} catch (Exception e) {
			// Clear buffer if there's an error
			if(e instanceof InputMismatchException)
				scanner.next();

			System.out.println("You have selected an invalid option..");
			return Prompt(scanner, options);
		}
	}
	
}
