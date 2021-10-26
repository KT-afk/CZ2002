package cz2002;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Restaurant {
	private String NameOfRestaurant;
	private String Address;
	private String OpeningHours;
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
	}
	
	public void newReservation() {
		Scanner sc = new Scanner(System.in);
		//Reservation resv = new Reservation();
		
		System.out.println("Enter name");
		System.out.println("----------------------");
		System.out.println("Name : ");
		String namein = sc.nextLine();
		
		System.out.println("Enter contact no.");
		System.out.println("----------------------");
		System.out.println("Contact : ");
		int contactin = sc.nextInt();
		
		System.out.println("Enter reservation date");
		System.out.println("----------------------");
		System.out.println("Date (dd/mm/yyyy) : ");
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
		
		System.out.println("Enter reservation time");
		System.out.println("----------------------");
		System.out.println("Time (hh:mm) : ");
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
		
		System.out.println("Enter number of pax");
		System.out.println("----------------------");
		System.out.println("No. : ");
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
