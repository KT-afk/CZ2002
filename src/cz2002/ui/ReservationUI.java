package cz2002.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import cz2002.system.ReservationSystem;

public class ReservationUI {
	public ReservationUI() {
		
	}
	public void makeReservationUI() {
		LocalTime currentTime = LocalTime.now();
		LocalDate currentDate = LocalDate.now();
		LocalDateTime currentDateTime = LocalDateTime.now();
		String customerId = "";
		Scanner sc = new Scanner(System.in);
		//Reservation resv = new Reservation();

		System.out.println("Enter name: \n");
		String nameIn = sc.nextLine();

		System.out.println("Enter contact no.: \n");
		String contactIn = sc.nextLine();
		System.out.println("Enter reservation date (dd/mm/yyyy): ");
		String dateIn = sc.nextLine();
		LocalDate reservationDate = LocalDate.parse(dateIn, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		while (reservationDate.isBefore(currentDate)) {
			System.out.println("Sorry! This date has already passed" + "\n");
			System.out.println("Enter reservation date (dd/mm/yyyy): ");
			dateIn = sc.nextLine();
			reservationDate = LocalDate.parse(dateIn, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		}
		System.out.println("Enter the session for which you wish to dine at our restaurant" + "\n" + "1) 1100-1500 \n" + "2) 1700-2200\n");
		int session = sc.nextInt();
		sc.nextLine();
		System.out.println("Please enter the time of arrival");
		String timeIn = sc.nextLine();
		LocalTime reservationTime = LocalTime.parse(timeIn, DateTimeFormatter.ofPattern("hh:mm"));
		while (session == 1 && reservationTime.isBefore(LocalTime.parse("11:00", DateTimeFormatter.ofPattern("hh:mm")))
				&& reservationTime.isAfter(LocalTime.parse("15:00", DateTimeFormatter.ofPattern("hh:mm")))) {
			System.out.println("You are entering an invalid time based on the session you selected.\n");
			System.out.println("Please enter the reservation time within your session(hh:mm): ");
			timeIn = sc.nextLine();
			reservationTime = LocalTime.parse(timeIn, DateTimeFormatter.ofPattern("hh:mm"));
		}
		while (session == 2 && reservationTime.isBefore(LocalTime.parse("18:00", DateTimeFormatter.ofPattern("hh:mm")))
				&& reservationTime.isAfter(LocalTime.parse("22:00", DateTimeFormatter.ofPattern("hh:mm")))) {
			System.out.println("You are entering an invalid time based on the session you selected.\n");
			System.out.println("Please enter the reservation time within your session(hh:mm): ");
			timeIn = sc.nextLine();
			reservationTime = LocalTime.parse(timeIn, DateTimeFormatter.ofPattern("hh:mm"));
		}

		System.out.println("Enter number of pax: ");
		int paxNo = sc.nextInt();
		if (paxNo > 10) {
			System.out.println("We only allow up to 10 people in a group at our restaurant. Please enter a smaller number\nEnter number of pax: ");
			paxNo = sc.nextInt();
		}
		ReservationSystem rSystem = new ReservationSystem();
		boolean rStatus = rSystem.makeReservation(nameIn, paxNo, contactIn, reservationDate, reservationTime, customerId);
		if(!rStatus)
			System.out.println("We are fully booked");
		else
			System.out.println("Success! The reservation has been booked!");
	}

}
