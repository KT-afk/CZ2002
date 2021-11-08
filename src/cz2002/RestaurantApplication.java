package cz2002;

import cz2002.entity.*;
import cz2002.system.ReservationSystem;
import cz2002.system.SaleRevenueSystem;
import cz2002.system.TableSystem;
import cz2002.ui.*;
import cz2002.util.ScannerUtil;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RestaurantApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Restaurant Reservation Management System");

		ArrayList<Staff> staffList = new ArrayList<>();
		staffList.add(new Staff("Amy", Person.Gender.Female, "Manager"));
		staffList.add(new Staff("Bob", Person.Gender.Male, "Waiter"));
		staffList.add(new Staff("Cat", Person.Gender.Female, "Chef"));
		staffList.add(new Staff("Dom", Person.Gender.Male, "Waiter"));

		int staffSelection = ScannerUtil.CustomPrompt(sc, "Please select current Staff Account", staffList.stream()
																					.map(staff -> staff.getName())
																					.toArray(String[]::new));
		sc.nextLine();
		System.out.printf("Please enter password: %s\n", "*".repeat(10));

		Staff currentStaff = staffList.get(staffSelection-1);

		RestaurantMenu menu = new RestaurantMenu();
		TableSystem tableSystem = new TableSystem();
		SaleRevenueSystem saleRevenueSystem = new SaleRevenueSystem();
		ReservationSystem reservationSystem = new ReservationSystem(tableSystem.getTableList());

		ReservationUI reservationUI = new ReservationUI(sc);
		RestaurantUI restaurantUI = new RestaurantUI(reservationSystem, tableSystem, sc);
		SaleRevenueUI saleRevenueUI = new SaleRevenueUI(saleRevenueSystem, sc);
		OrderUI orderUI = new OrderUI(sc, reservationSystem, tableSystem, menu);

		int capacity = 2;

		for(int i = 0; i < 10; i++) {
			tableSystem.addTable(capacity);
			capacity = capacity+2;
			
			if(capacity > 10)
				capacity = 2;
		}
		
		while(true) {
			int option = ScannerUtil.Prompt(sc,
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

			sc.nextLine();

			switch (option) {
				case 1:
					//ManageMenu(sc);
					MenuUI menuManager = new FoodDishUI(sc, menu.alaCarteMenu);
					menuManager.run("Menu Item");
					menu.save();
					break;
				case 2:
					//ManagePromotionSet(sc);
					menuManager = new PromotionSetUI(sc, menu.setPackageMenu, menu.alaCarteMenu);
					menuManager.run("Set Package");
					menu.save();
					break;
				case 3:
					orderUI.manageOrders(currentStaff, tableSystem.getTableList());
					break;
				case 4:
					reservationUI.makeReservationUI(tableSystem.getTableList());
					break;
				case 5:
					restaurantUI.checkTableAvailability();
					break;
				case 6:
					orderUI.printOrderInvoice();
					break;
				case 7:
					saleRevenueUI.printSaleRevenueReport();
					break;
				case 8:
					return;
			}
		}
	}
}
