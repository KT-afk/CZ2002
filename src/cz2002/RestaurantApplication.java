package cz2002;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RestaurantApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Restaurant Reservation Management System");

		while(true) {
			int option = Prompt(sc,
		"Manage Menu Items",
				"Manage Promotion Sets",
				"Manage Orders",
				"Manage Reservations",
				"Check Table Availability",
				"Print Order Invoice",
				"Print Sale Revenue Report",
				"Quit"
			);

			if(option == 1)
				ManageMenu(sc);
			else if(option == 2)
				ManagePromotionSet(sc);
			else if(option == 3)
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
				break;
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
		System.out.println("\nPlease select one of the following options: ");
		for(int i = 1; i <= options.length; i++)
			System.out.printf("%d) %s\n", i, options[i-1]);
		System.out.print("> ");

		try {
			int option = scanner.nextInt();
			if(option > options.length)
				throw new Exception();

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
