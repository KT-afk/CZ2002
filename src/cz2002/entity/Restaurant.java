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
	// Order order = new Order();

	// Constructor
	public Restaurant(String NameOfRestaurant, String Address, String OpeningHours) {
		this.setNameOfRestaurant(NameOfRestaurant);
		this.setAddress(Address);
		this.setOpeningHours(OpeningHours);
	}

	public void generateSaleRevenueRep() {

	}

	public void printRestaurantDetails() {
		System.out.println("Restaurant: " + this.NameOfRestaurant);
		System.out.println("Address: " + this.Address);
		System.out.println("Opening Hours: " + this.OpeningHours);
		System.out.println("-----------------------------------");
	}

	public void newOrder() {
		Scanner sc = new Scanner(System.in);
		// Order ord = new Order();

	}

	// Getter/Setter for opening hours
	public String getOpeningHours() {
		return OpeningHours;
	}

	public void setOpeningHours(String openingHours) {
		OpeningHours = openingHours;
	}

	// Getter/Setter for address
	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	// Getter/Setter for name of restaurant
	public String getNameOfRestaurant() {
		return NameOfRestaurant;
	}

	public void setNameOfRestaurant(String nameOfRestaurant) {
		NameOfRestaurant = nameOfRestaurant;
	}
}
