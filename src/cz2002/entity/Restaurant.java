package cz2002.entity;

public class Restaurant {
	private String nameOfRestaurant;
	private String address;
	private String openingHours;

	// Constructor
	public Restaurant(String nameOfRestaurant, String address, String openingHours) {
		this.nameOfRestaurant = nameOfRestaurant;
		this.address = address;
		this.openingHours = openingHours;
	}

	public void printRestaurantDetails() {
		System.out.printf("%15s: %s:\n", "Name:", nameOfRestaurant);
		System.out.printf("%15s: %s:\n", "Address:", address);
		System.out.printf("%15s: %s:\n", "OpeningHours:", openingHours);
		System.out.println("-----------------------------------");
	}
}
