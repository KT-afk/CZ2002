package cz2002;

import cz2002.ui.ManageFoodDish;
import cz2002.ui.ManagePromotionSet;
import cz2002.ui.MenuManager;
import cz2002.util.ScannerUtil;

import java.util.List;
import java.util.Scanner;

public class RestaurantApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Restaurant Reservation Management System");

		// [TODO] Save Restaurant Menu somewhere
		RestaurantMenu menu = new RestaurantMenu();
		menu.alaCarteMenu.add(new FoodDish("Foo", "Bar", 1.2, FoodDish.Type.MAIN_COURSE));
		menu.alaCarteMenu.add(new FoodDish("Foo1", "Bar", 1.2, FoodDish.Type.MAIN_COURSE));
		menu.alaCarteMenu.add(new FoodDish("Foo2", "Bar", 1.2, FoodDish.Type.MAIN_COURSE));
		menu.alaCarteMenu.add(new FoodDish("Foo3", "Bar", 1.2, FoodDish.Type.MAIN_COURSE));

		menu.alaCarteMenu.get(1).toggleEnable();
		menu.alaCarteMenu.get(3).toggleEnable();

		menu.setPackageMenu.add(new SetPackage("FooSet", "Bar", 20));
		menu.setPackageMenu.add(new SetPackage("FooSetDeluxe", "Bar", 20));

		menu.setPackageMenu.get(0).addFood(menu.alaCarteMenu.get(0));
		menu.setPackageMenu.get(1).addFood(menu.alaCarteMenu.get(0));
		menu.setPackageMenu.get(1).addFood(menu.alaCarteMenu.get(2));

		while(true) {
			int option = ScannerUtil.Prompt(sc,
		"Manage Menu Items",
				"Manage Promotion Sets",
				"Manage Orders",
				"Manage Reservations",
				"Check Table Availability",
				"Print Order Invoice",
				"Print Sale Revenue Report",
				"Change Date/Time",
				"Quit"
			);

			if(option == 1) {
				MenuManager menuManager = new ManageFoodDish(sc, (List<MenuItem>) (List<? extends MenuItem>) menu.alaCarteMenu);
				menuManager.run("Menu Item");
			} else if(option == 2) {
				MenuManager menuManager = new ManagePromotionSet(sc, (List<MenuItem>) (List<? extends MenuItem>) menu.setPackageMenu, menu.alaCarteMenu);
				menuManager.run("Set Package");
			} else if(option == 3)
				ManageOrder(sc);
			else if(option == 4)
				ManageReservation(sc);
			else if(option == 5)
				CheckAvailability(sc);
			else if(option == 6)
				PrintOrderInvoice(sc);
			else if(option == 7)
				PrintRevenueReport(sc);
			else if(option == 8)
				; // Placeholder
			else
				break;
		}
	}

	public static void ManagePromotionSet(Scanner sc) {
		int option = ScannerUtil.Prompt(sc, "Create Promotion Set", "Edit Promotion Set", "Remove Promotion Set");

		if(option == 1)
			; // Placeholder
		else if(option == 2)
			; // Placeholder
		else if(option == 3)
			; // Placeholder
	}

	public static void ManageOrder(Scanner sc) {
		int option = ScannerUtil.Prompt(sc, "Create Order", "View Order", "Edit Order");

		if(option == 1)
			; // Placeholder
		else if(option == 2)
			; // Placeholder
		else if(option == 3)
			; // Placeholder
	}

	public static void ManageReservation(Scanner sc) {
		int option = ScannerUtil.Prompt(sc,"Create Reservation Booking", "View Reservation Booking", "Remove Reservation Booking");

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
}
