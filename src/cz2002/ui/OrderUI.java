package cz2002.ui;
import cz2002.entity.*;
import cz2002.entity.Person.Gender;
import cz2002.system.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import cz2002.SystemClock;

public class OrderUI {
	
	private Scanner sc;

	public OrderUI(Scanner scanner) {
		sc = scanner;
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
		int orderType;
		String staffin, staffpos, staffgen;
		Gender gender;
		ReservationSystem reservationSystem = new ReservationSystem(tables);
		
		ArrayList<FoodDish> dishItems = new ArrayList<FoodDish>();
		ArrayList<SetPackage> packageItems = new ArrayList<SetPackage>();

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
					
					ArrayList<MenuItem> ordered = new ArrayList<MenuItem>();
					
					
					DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					
					Order newOrder = new Order(orStaff, ordered, resv, resv.getTableNo(), SystemClock.GetCurrentDateTime().format(formatter1));
							
					OrderSystem.addOrder(newOrder);
					
					break;
				case 2:
					boolean stop = false;
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					System.out.printf("The current time is %s\n", SystemClock.GetCurrentDateTime().format(formatter));
					
					do {
						
					} while(!stop);
					
					
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
