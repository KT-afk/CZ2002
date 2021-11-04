package cz2002.entity;
import cz2002.entity.Order;
import cz2002.entity.Reservation;
import cz2002.entity.Table;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.ArrayList;

public class Restaurant {
	private static final int MAX_TABLE = 20;
	private String NameOfRestaurant;
	private String Address;
	private String OpeningHours;
	private ArrayList<Reservation> reservedList;
	private ArrayList<Order> orderList;
	private ArrayList<Table> tableList;
	private int tableVacant;
	//Order order = new Order();
	
	//Constructor
	public Restaurant (String NameOfRestaurant, String Address, String OpeningHours) {
		this.setNameOfRestaurant(NameOfRestaurant);
		this.setAddress(Address);
		this.setOpeningHours(OpeningHours);
	}
	
	public void generateSaleRevenueRep () {
		
	}
	
	public void printRestaurantDetails () {
		System.out.println("Restaurant: " + this.NameOfRestaurant);
		System.out.println("Address: " + this.Address);
		System.out.println("Opening Hours: " + this.OpeningHours);
		System.out.println("-----------------------------------");
	}
	
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
	
	public void newOrder() {
		Scanner sc = new Scanner(System.in);
		//Order ord = new Order();
		
	}
	
	//Getter/Setter for opening hours
	public String getOpeningHours() {
		return OpeningHours;
	}

	public void setOpeningHours(String openingHours) {
		OpeningHours = openingHours;
	}
	//Getter/Setter for address
	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	//Getter/Setter for name of restaurant
	public String getNameOfRestaurant() {
		return NameOfRestaurant;
	}

	public void setNameOfRestaurant(String nameOfRestaurant) {
		NameOfRestaurant = nameOfRestaurant;
	}
}
