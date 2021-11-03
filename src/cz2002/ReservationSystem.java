package cz2002;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

public class ReservationSystem {
	protected  ArrayList<Table> tableList;
	//Each reservation has a table allocated
	protected ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	public ReservationSystem(ArrayList<Table> tableList) {
		this.tableList = tableList;
		
	}
	public void initDateReservationList(LocalDate date)
	{
		
	}
	public void removeReservation() 
	{
		
	}
	public boolean makeReservation() {
		LocalTime currentTime = LocalTime.now();
		LocalDate currentDate = LocalDate.now();
		LocalDateTime currentDateTime = LocalDateTime.now();
		int tableNo = -1;
		String customerId;
		Scanner sc = new Scanner(System.in);
		//Reservation resv = new Reservation();
		
		System.out.println("Enter name: \n");
		String nameIn = sc.nextLine();
		
		System.out.println("Enter contact no.: \n");
		String contactIn = sc.nextLine();
		System.out.println("Enter reservation date (dd/mm/yyyy): ");
		String dateIn = sc.nextLine();
		LocalDate reservationDate = LocalDate.parse(dateIn, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		while(reservationDate.isBefore(currentDate) )
		{
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
		while(session == 1 && reservationTime.isBefore(LocalTime.parse("11:00", DateTimeFormatter.ofPattern("hh:mm"))) 
				&& reservationTime.isAfter(LocalTime.parse("15:00", DateTimeFormatter.ofPattern("hh:mm"))))
		{
			System.out.println("You are entering an invalid time based on the session you selected.\n");
			System.out.println("Please enter the reservation time within your session(hh:mm): ");
			timeIn = sc.nextLine();
			reservationTime = LocalTime.parse(timeIn, DateTimeFormatter.ofPattern("hh:mm"));
		}
		while(session == 2 && reservationTime.isBefore(LocalTime.parse("17:00", DateTimeFormatter.ofPattern("hh:mm"))) 
				&& reservationTime.isAfter(LocalTime.parse("22:00", DateTimeFormatter.ofPattern("hh:mm"))))
		{
			System.out.println("You are entering an invalid time based on the session you selected.\n");
			System.out.println("Please enter the reservation time within your session(hh:mm): ");
			timeIn = sc.nextLine();
			reservationTime = LocalTime.parse(timeIn, DateTimeFormatter.ofPattern("hh:mm"));
		}
		
		System.out.println("Enter number of pax: ");
		int paxNo = sc.nextInt();
		if(paxNo > 10)
		{
			System.out.println("We only allow up to 10 people in a group at our restaurant. Please enter a smaller number\nEnter number of pax: ");
			paxNo = sc.nextInt();
		}
		//Check if conflict with any existing reservation
		tableNo = checkAvailableTables();
		if(tableNo == -1)
		{
			for(int i=0; i< reservationList.size(); i++)
			{
				if(!reservationList.get(i).getDate().equals(reservationDate))
					continue;
				if((reservationTime.until(reservationList.get(i).getTime(), ChronoUnit.MINUTES) <= 75) ||
						(reservationTime.until(reservationList.get(i).getTime(), ChronoUnit.MINUTES) >= -75))
				{
					System.out.println("The date and time you are looking to reserve is occupied. Please choose another date time.");
					return false;
				}
			}
		}
		try
		{    
			  //Creating the object    
			  Reservation s1 =new Reservation(nameIn, paxNo, contactIn, reservationDate, reservationTime, tableNo, customerId);    
			  //Creating stream and writing the object    
			  FileOutputStream fout=new FileOutputStream("f.txt");    
			  ObjectOutputStream out=new ObjectOutputStream(fout);    
			  out.writeObject(s1);    
			  out.flush();    
			  //closing the stream    
			  out.close();    
			  System.out.println("success");    
		}
		catch(Exception e){System.out.println(e);}    
			 }    
		//Reservation newReservation = new Reservation(namein, paxNo, contactin, reservationDate, reservationTime, table, Customer customer);
	}
	public int checkAvailableTables() {
		for(int i = 0; i < tableList.size(); i++)
		{
			if(tableList.get(i).getStatus() == "vacant")
			{
				return tableList.get(i).getTableNo();
			}
		}
		return -1;
	}
	
	
}
