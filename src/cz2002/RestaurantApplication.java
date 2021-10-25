package cz2002;

import java.util.Scanner;

public class RestaurantApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Restaurant Reservation Management System");

		while(true) {
			System.out.println("\nPlease select one of the following options: ");
			System.out.println("1) Manage Menu Items");
			System.out.println("2) Manage Promotion Sets");
			System.out.println("3) Manage Orders");
			System.out.println("4) Manage Reservations");
			System.out.println("5) Check Table Availability");
			System.out.println("6) Print Order Invoice");
			System.out.println("7) Print Sale Revenue Report");
			System.out.println("8) Quit");
			System.out.print("> ");
			int option = sc.nextInt();

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
			else
				System.out.println("You have selected an invalid option");
		}
	}

	public static void ManageMenu(Scanner sc) {
		System.out.println("\nPlease select one of the following options: ");
		System.out.println("1) Create Menu Item");
		System.out.println("2) Edit Menu Item");
		System.out.println("3) Remove Menu Item");
		System.out.print("> ");
		int option = sc.nextInt();

		if(option == 1)
			; // Placeholder
		else if(option == 2)
			; // Placeholder
		else if(option == 3)
			; // Placeholder
		else {
			System.out.println("You have selected an invalid option..");
			ManageMenu(sc);
		}
	}

	public static void ManagePromotionSet(Scanner sc) {
		System.out.println("\nPlease select one of the following options: ");
		System.out.println("1) Create Promotion Set");
		System.out.println("2) Edit Promotion Set");
		System.out.println("3) Remove Promotion Set");
		System.out.print("> ");
		int option = sc.nextInt();

		if(option == 1)
			; // Placeholder
		else if(option == 2)
			; // Placeholder
		else if(option == 3)
			; // Placeholder
		else {
			System.out.println("You have selected an invalid option..");
			ManagePromotionSet(sc);
		}
	}

	public static void ManageOrder(Scanner sc) {
		System.out.println("\nPlease select one of the following options: ");
		System.out.println("1) Create Order");
		System.out.println("2) View Order");
		System.out.println("3) Edit Order");
		System.out.print("> ");
		int option = sc.nextInt();

		if(option == 1)
			; // Placeholder
		else if(option == 2)
			; // Placeholder
		else if(option == 3)
			; // Placeholder
		else {
			System.out.println("You have selected an invalid option..");
			ManageOrder(sc);
		}
	}

	public static void ManageReservation(Scanner sc) {
		System.out.println("\nPlease select one of the following options: ");
		System.out.println("1) Create Reservation Booking");
		System.out.println("2) View Reservation Booking");
		System.out.println("3) Remove Reservation Booking");
		System.out.print("> ");
		int option = sc.nextInt();

		if(option == 1)
			; // Placeholder
		else if(option == 2)
			; // Placeholder
		else if(option == 3)
			; // Placeholder
		else {
			System.out.println("You have selected an invalid option..");
			ManageReservation(sc);
		}
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
