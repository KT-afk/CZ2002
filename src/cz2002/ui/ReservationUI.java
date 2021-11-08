package cz2002.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cz2002.entity.Reservation;
import cz2002.entity.Table;
import cz2002.system.ReservationSystem;
import cz2002.system.TableSystem;

public class ReservationUI {

	private Scanner sc;
	private ReservationSystem rSystem;

	public ReservationUI(Scanner scanner, List<Table> tables) {
		sc = scanner;
		rSystem = new ReservationSystem(tables);
	}

	public void checkReservationUI() {
		System.out.println("Which date would you like to view the reservations for? Please enter in dd/MM/yyyy");
		String date = sc.nextLine();
		LocalDate d = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		ArrayList<Reservation> rList = rSystem.getPastReservation(d);
		for (int i = 0; i < rList.size(); i++) {
			System.out.println("Date: " + date);
			System.out.println("Time: " + rList.get(i).getTime());
			System.out.println("Name: " + rList.get(i).getName());
			System.out.println("ReservationID: " + rList.get(i).getId());
			System.out.println("NoOfPax: " + rList.get(i).getNoOfPax());
			System.out.println("TableNo: " + rList.get(i).getTableNo());
		}
	}

	public void removeReservationUI() {
		System.out.println("What date is the reservation you would you like to remove?");
		String date = sc.nextLine();
		LocalDate d = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Which reservation would you like to remove?");
		String rID = sc.nextLine();
		if (rSystem.removeReservation(rID, d)) {
			System.out.println("Reservation has been removed successfully");
		} else {
			System.out.println("The reservation you would like to remove cannot be found");
		}
	}

	public void makeReservationUI() {
		LocalDate currentDate = LocalDate.now(); // Pick some date to set the number of days in advance
		String customerId = "";
		int choiceInterval;
		int session;
		LocalTime reservationTime = LocalTime.now();
		boolean continueOn = true;
		// Reservation resv = new Reservation();

		System.out.println("Enter name: ");
		String nameIn = sc.nextLine();

		System.out.println("Enter contact no.: ");
		String contactIn = sc.nextLine();
		System.out.println("Enter reservation date (dd/mm/yyyy): ");
		String dateIn = sc.nextLine();
		LocalDate reservationDate = LocalDate.parse(dateIn, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		while (reservationDate.isBefore(currentDate)) {
			System.out.println("Sorry! This date has already passed!");
			System.out.println("Enter reservation date (dd/mm/yyyy): ");
			dateIn = sc.nextLine();
			reservationDate = LocalDate.parse(dateIn, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}
		while (reservationDate.isBefore(currentDate.plusDays(1))) {
			System.out.println("Sorry! You are only allowed to make a reservation 1 day in advance");
			System.out.println("Enter reservation date (dd/mm/yyyy): ");
			dateIn = sc.nextLine();
			reservationDate = LocalDate.parse(dateIn, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}
		session = 0;
		System.out.println("Enter the session for which you wish to dine at our restaurant" + "\n" + "1) 1100-1330 \n"
				+ "2) 1800-2030\n");
		session = sc.nextInt();
		sc.nextLine();
		while (session != 1 && session != 2) {
			System.out.println("An invalid session has been chosen.\n"
					+ "Enter the session for which you wish to dine at our restaurant" + "\n" + "1) 1100-1330 \n"
					+ "2) 1800-2030\n");
			session = sc.nextInt();
			sc.nextLine();
		}
		while (session == 1 && continueOn) {
			System.out.println("Please enter your choice based on the reservation time intervals available shown.\n");
			System.out.println("1) 1100 	2) 1115		3) 1130		4) 1145\n"
					+ "5) 1200		6) 1215		7) 1230		8) 1245\n" + "9) 1300		10) 1315		11) 1330\n");
			choiceInterval = sc.nextInt();
			switch (choiceInterval) {
			case 1: {
				reservationTime = LocalTime.parse("11:00", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}
			case 2: {
				reservationTime = LocalTime.parse("11:15", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}
			case 3: {
				reservationTime = LocalTime.parse("11:30", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}
			case 4: {
				reservationTime = LocalTime.parse("11:45", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}

			case 5: {
				reservationTime = LocalTime.parse("12:00", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}
			case 6: {
				reservationTime = LocalTime.parse("12:15", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}
			case 7: {
				reservationTime = LocalTime.parse("12:30", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;

			}
			case 8: {
				reservationTime = LocalTime.parse("12:45", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}
			case 9: {
				reservationTime = LocalTime.parse("13:00", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}
			case 10: {
				reservationTime = LocalTime.parse("13:15", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}
			case 11: {
				reservationTime = LocalTime.parse("13:30", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}
			default: {
				System.out.println("Invalid choice\n");
			}
			}

		}
		continueOn = true;
		while (session == 2 && continueOn) {
			System.out.println("Please enter your choice based on the reservation time intervals available shown.\n");
			System.out.println("1) 1800 	2) 1815		3) 1830		4) 1845\n"
					+ "5) 1900		6) 1915		7) 1930		8) 1945\n" + "9) 2000		10) 2015		11) 2030\n");
			choiceInterval = sc.nextInt();
			switch (choiceInterval) {
			case 1: {
				reservationTime = LocalTime.parse("18:00", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}
			case 2: {
				reservationTime = LocalTime.parse("18:15", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}
			case 3: {
				reservationTime = LocalTime.parse("18:30", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}
			case 4: {
				reservationTime = LocalTime.parse("18:45", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}

			case 5: {
				reservationTime = LocalTime.parse("19:00", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}
			case 6: {
				reservationTime = LocalTime.parse("19:15", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}
			case 7: {
				reservationTime = LocalTime.parse("19:30", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;

			}
			case 8: {
				reservationTime = LocalTime.parse("19:45", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}
			case 9: {
				reservationTime = LocalTime.parse("20:00", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}
			case 10: {
				reservationTime = LocalTime.parse("20:15", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}
			case 11: {
				reservationTime = LocalTime.parse("20:30", DateTimeFormatter.ofPattern("HH:mm"));
				continueOn = false;
				break;
			}
			default: {
				System.out.println("Invalid choice\n");
			}
			}
		}

		System.out.println("Enter number of pax (1-10): ");
		int paxNo = sc.nextInt();
		while (paxNo > 10 || paxNo <= 0) {
			if (paxNo > 10)
			{
				System.out.println(
						"We only allow up to 10 people in a group at our restaurant. Please enter a smaller number\nEnter number of pax: ");
			}
			else
			{
				System.out.println("Number of pax cannot be less than or equal to 0. Please enter a valid number\nEnter number of pax: ");
			}
			paxNo = sc.nextInt();
		}
		String rID;
		rID = rSystem.makeReservation(nameIn, paxNo, contactIn, reservationDate, reservationTime, customerId);
		if (rID.isEmpty())
			System.out.println("We are fully booked");
		else {
			System.out.println("Success! The reservation has been booked!");
			System.out.println("Your reservation ID is " + rID);
		}

	}

}
