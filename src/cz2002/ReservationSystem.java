package cz2002;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReservationSystem {

	public void newReservation() {
		Scanner sc = new Scanner(System.in);
		//Reservation resv = new Reservation();
		
		System.out.println("Enter name: ");
		String namein = sc.nextLine();
		
		System.out.println("Enter contact no.: ");
		int contactin = sc.nextInt();
		
		System.out.println("Enter reservation date (dd/mm/yyyy): ");
		String datein = sc.nextLine(); 
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date dateinf = null;
		try {
		    //Parsing the String
		    dateinf = dateFormat.parse(datein);
		} catch (ParseException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
		System.out.println("Enter reservation time (hh:mm): ");
		String timein = sc.nextLine();
		
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("hh:mm");
		
		try {
		    //Parsing the String
		    Date timeinf = dateFormat1.parse(timein);
		} catch (ParseException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		//System.out.println("Time: " + dateFormat1.format(timein));
		
		System.out.println("Enter number of pax: ");
		int paxno = sc.nextInt();
		
		
	}
}
