package cz2002.entity;

/**
 *     Restaurant class to contain restaurant information
 *     @author Abdul Siddiq
 *     @version 1.0
 *     @since 2021-11-08
 */
public class Restaurant {
	private String nameOfRestaurant;
	private String address;
	private String openingHours;

	/**
	 * Creates a Restaurant object
	 * @param nameOfRestaurant
	 * @param address
	 * @param openingHours
	 */
	public Restaurant(String nameOfRestaurant, String address, String openingHours) {
		this.nameOfRestaurant = nameOfRestaurant;
		this.address = address;
		this.openingHours = openingHours;
	}

	/**
	 * Print restaurant information
	 */
	public void printRestaurantDetails() {
		System.out.printf("%15s: %s\n", "Name", nameOfRestaurant);
		System.out.printf("%15s: %s\n", "Address", address);
		System.out.printf("%15s: %s\n", "OpeningHours", openingHours);
		System.out.println("-----------------------------------");
	}
}
