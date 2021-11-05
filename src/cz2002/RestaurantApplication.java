package cz2002;

import cz2002.system.TableSystem;
import cz2002.ui.ReservationUI;
import cz2002.ui.RestaurantUI;

import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RestaurantApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Restaurant Reservation Management System");

		ReservationUI reservationUI = new ReservationUI(sc);
		RestaurantUI restaurantUI = new RestaurantUI(sc);

		while(true) {
			int option = Prompt(sc,
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

			switch (option) {
				case 1 -> ManageMenu(sc);
				case 2 -> ManagePromotionSet(sc);
				case 3 -> ManageOrder(sc);
				case 4 -> reservationUI.makeReservationUI();
				case 5 -> restaurantUI.checkTableAvailability(restaurantUI.createMockTable());
				case 6 -> PrintOrderInvoice(sc);
				case 7 -> PrintRevenueReport(sc);
				case 8 -> { return; }
			}
		}
	}

	public static void ManageMenu(Scanner sc) {
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
	}

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
		System.out.println(SystemClock.GetCurrentDateTime().format(formatter));
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
