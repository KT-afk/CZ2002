package cz2002.system;

import cz2002.entity.Reservation;
import cz2002.entity.Table;

import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;

public class ReservationSystem {
	protected ArrayList<Table> tList;
	// Each reservation has a table allocated

	public ReservationSystem() {

	}

	public void reservationArrival(String Id) {
		LocalDate d = LocalDate.parse(Id.substring(0, 8), DateTimeFormatter.ofPattern("ddMMyyyy"));
		ArrayList<Reservation> rList = getPastReservation(d);
		int i;
		for (i = 0; i < rList.size(); i++) {
			if (rList.get(i).getId() == Id) {
				break;
			}
		}
		rList.remove(i);
	}

	public void removeExpiredReservations(LocalDate d) {
		LocalTime reservationExpiry;
		int i = 0;
		ArrayList<Reservation> rList;
		rList = getPastReservation(d);
		Iterator<Reservation> reservation = rList.iterator();
		//
		while (reservation.hasNext()) {
			reservationExpiry = rList.get(i).getTime().plusMinutes(15);
			if (reservationExpiry.isBefore(LocalTime.now())) {
				reservation.remove();
				System.out.println("Removed 1 expired reservation\n");
			}
			i++;
		}
	}

	// For walk in
	// Find an available table
	// Check the reservations for that table
	public boolean checkTableForReservation(int tableNo) {
		LocalTime reservationTime;
		ArrayList<Reservation> rList = getPastReservation(LocalDate.now());
		for (int i = 0; i < rList.size(); i++) {
			reservationTime = rList.get(i).getTime();
			if (rList.get(i).getTableNo() == tableNo) {
				// We need a method to force the customer to leave after 1hr 30mins for the next
				// reservation if there is a reservation
				// We cannot allow a reservation/walk-in to be within 1hr 30mins of another
				// reservation
				// Set tableNo to -1 to indicate there are no tables for this reservation as it
				// is fully booked
				if ((reservationTime.until(rList.get(i).getTime(), ChronoUnit.MINUTES) <= 90)
						|| (reservationTime.until(rList.get(i).getTime(), ChronoUnit.MINUTES) >= -90)) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean makeReservation(String nameIn, int paxNo, String contactIn, LocalDate reservationDate,
			LocalTime reservationTime, String customerId) {

		// Is there a need for customer id?
		customerId = nameIn + contactIn;
		ArrayList<Reservation> rList;
		String fileName = "reservation" + reservationDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ".ser";
		int tableNo = -1;
		rList = getPastReservation(reservationDate);
		// Check for available tables(no reservation assigned to that table yet)
		// Check if conflict with any existing reservation by filtering through the
		// table list
		for (int j = 0; j < tList.size(); j++) {
			if (tList.get(j).getCapacity() >= paxNo) {
				// Get the tableNo for those bigger than the paxNo
				tableNo = tList.get(j).getTableNo();
				// Check for reservations assigned to that table for any conflicts
				if (!checkTableForReservation(tableNo)) {
					tableNo = -1;
				}
			}
		}
		// Fully booked
		if (tableNo == -1)
			return false;
		Reservation r = new Reservation(nameIn, paxNo, contactIn, reservationDate, reservationTime, tableNo,
				customerId);
		rList.add(r);
		writeReservationToFile(rList, fileName);
		return true;
	}

	// Create the file and serialize the list with its new addition into the file
	public void writeReservationToFile(ArrayList<Reservation> rList, String fileName) {
		try {
			FileOutputStream fout = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(rList);
			out.flush();
			// closing the stream
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Get the past reservations on the date we are looking to make a reservation
	// by going through the arrayList for reservations on that date
	public ArrayList<Reservation> getPastReservation(LocalDate d) {
		// Deserialize current reservations for that date
		File f = new File("reservation" + d.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ".ser");
		ArrayList<Reservation> rList = new ArrayList<Reservation>();
		if (f.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
				rList = (ArrayList<Reservation>) ois.readObject();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return rList;
	}

}