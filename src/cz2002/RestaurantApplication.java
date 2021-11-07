package cz2002;

import cz2002.entity.*;
import cz2002.system.TableSystem;
import cz2002.ui.*;

import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RestaurantApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Restaurant Reservation Management System");

		ReservationUI reservationUI = new ReservationUI(sc);
		RestaurantUI restaurantUI = new RestaurantUI(sc);
		OrderUI orderUI = new OrderUI(sc);

		TableSystem tableSystem = new TableSystem();

		int capacity = 2;

		for(int i = 0; i < 10; i++) {
			tableSystem.addTable(capacity++);

			if(capacity >= 10)
				capacity = 2;
		}
		
		RestaurantMenu menu = new RestaurantMenu();
		//Initialise random food and set packages for now
		menu.alaCarteMenu.add(new FoodDish("Foo", "Bar", 1.2, FoodDish.menuItemType.MAIN_COURSE));
		menu.alaCarteMenu.add(new FoodDish("Foo1", "Bar", 1.2, FoodDish.menuItemType.MAIN_COURSE));
		menu.alaCarteMenu.add(new FoodDish("Foo2", "Bar", 1.2, FoodDish.menuItemType.MAIN_COURSE));
		menu.alaCarteMenu.add(new FoodDish("Foo3", "Bar", 1.2, FoodDish.menuItemType.MAIN_COURSE));

		menu.alaCarteMenu.get(1).toggleEnable();
		menu.alaCarteMenu.get(3).toggleEnable();

		menu.setPackageMenu.add(new SetPackage("FooSet", "Bar", 20));
		menu.setPackageMenu.add(new SetPackage("FooSetDeluxe", "Bar", 20));

		menu.setPackageMenu.get(0).addFood(menu.alaCarteMenu.get(0));
		menu.setPackageMenu.get(1).addFood(menu.alaCarteMenu.get(0));
		menu.setPackageMenu.get(1).addFood(menu.alaCarteMenu.get(2));
		
		while(true) {
			int option = Prompt(sc,
				"Manage Menu Items",
				"Manage Promotion Sets",
				"Manage Orders",
				"Manage Reservations",
				"Check Table Availability",
				"Print Order Invoice",
				"Print Sale Revenue Report",
//				"Change Date/Time",
				"Quit"
			);

			switch (option) {
				case 1:
					//ManageMenu(sc);
					MenuUI menuManager = new FoodDishUI(sc, menu.alaCarteMenu);
					menuManager.run("Menu Item");
					break;
				case 2:
					//ManagePromotionSet(sc);
					menuManager = new PromotionSetUI(sc, menu.setPackageMenu, menu.alaCarteMenu);
					menuManager.run("Set Package");
					break;
				case 3:
					orderUI.manageOrders(tableSystem.getTableList());
					break;
				case 4:
					reservationUI.makeReservationUI(tableSystem.getTableList());
					break;
				case 5:
					restaurantUI.checkTableAvailability(tableSystem.getTableList());
					break;
				case 6:
					PrintOrderInvoice(sc);
					break;
				case 7:
					PrintRevenueReport(sc);
					break;
				case 8:
					return;
			}
		}
	}

	/*public static void ManageMenu(Scanner sc) {
		int option = Prompt(sc, "Create Menu Item", "Edit Menu Item", "Remove Menu Item");

		if(option == 1)
			; // Placeholder
		else if(option == 2)
			; // Placeholder
		else if(option == 3)
			; // Placeholder
	}

	public static void ManagePromotionSet(Scanner sc) {
		int option = Prompt(sc, "Create Promotion Set", "Edit Promotion Set", "Remove Promotion Set");

		if(option == 1)
			; // Placeholder
		else if(option == 2)
			; // Placeholder
		else if(option == 3)
			; // Placeholder
	}*/

	public static void ManageOrder(Scanner sc) {
		int option = Prompt(sc, "Create Order", "View Order", "Edit Order");

		if(option == 1)
			; // Placeholder
		else if(option == 2)
			; // Placeholder
		else if(option == 3)
			; // Placeholder
	}

	public static void ManageReservation(Scanner sc) {
		int option = Prompt(sc,"Create Reservation Booking", "View Reservation Booking", "Remove Reservation Booking");

		if(option == 1)
			; // Placeholder
		else if(option == 2)
			; // Placeholder
		else if(option == 3)
			; // Placeholder
	}

	public static void CheckAvailability(Scanner sc) {
		// Placeholder
	}

	public static void PrintOrderInvoice(Scanner sc) {
		// Placeholder
	}

	public static void PrintRevenueReport(Scanner sc) {
		// Placeholder
	}

	// Utility Functions
	public static int Prompt(Scanner scanner, String... options) {
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
