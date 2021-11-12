package cz2002.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Order class
 * 
 * @author Tran Trung Dung
 * @version 1.0
 * @since 2020-11-01
 */
public class Order implements Serializable {
	/**
	 * Order ID counter
	 */
	public static Integer OrderIDCounter = 1;
	/**
	 * Order ID
	 */
	private Integer id;
	/**
	 * Staff that create order
	 */
	private Staff creator;
	/**
	 * List of Food Dish item in this order
	 */
	private ArrayList<FoodDish> fdItems;
	/**
	 * List of package item in this order
	 */
	private ArrayList<SetPackage> packItems;
	/**
	 * Reservation Information
	 */
	private Reservation reserveInfo;
	/**
	 * Table of this order
	 */
	private Table table;
	/**
	 * Start time of the order
	 */
	private LocalDateTime start;
	/**
	 * Whether order is completed
	 */
	private boolean isCompleted;

	/**
	 * Constructor
	 * 
	 * @param creator     Staff that create this order
	 * @param fdItems     List of Food Dish item in this order
	 * @param packItems   List of package item in this order
	 * @param reserveInfo Reservation Information
	 * @param table       Table of this order
	 * @param start       Start time of the order
	 */
	public Order(Staff creator, ArrayList<FoodDish> fdItems, ArrayList<SetPackage> packItems, Reservation reserveInfo,
			Table table, LocalDateTime start) {
		id = OrderIDCounter++;
		this.creator = creator;
		this.fdItems = fdItems;
		this.packItems = packItems;
		this.reserveInfo = reserveInfo;
		this.table = table;
		this.start = start;
		this.isCompleted = false;
	}

	/**
	 * This method is to get Order ID
	 * 
	 * @return id of this order
	 */
	public Integer getID() {
		return id;
	}
	/**
	 * This method checks whether status is compeleted
	 * @return Order status
	 */
	public boolean getStatus() {
		return isCompleted;
	}
	/**
	 * This method makes the order complete
	 */
	public void setComplete() {
		this.isCompleted = true;;
	}
	/**
	 * This method is to get Staff that created this order
	 * 
	 * @return Staff that created this order
	 */
	public Staff getCreator() {
		return creator;
	}

	/**
	 * This method is to get List of Food Dish item in this order
	 * 
	 * @return List of Food Dish item in this order
	 */
	public ArrayList<FoodDish> getDishItems() {
		return fdItems;
	}

	/**
	 * This method is to get List of Package item in this order
	 * 
	 * @return List of Package item in this order
	 */
	public ArrayList<SetPackage> getPackItems() {
		return packItems;
	}

	/**
	 * This method is to get Reservation Information
	 * 
	 * @return Reservation object of the Reservation
	 */
	public Reservation getReserveInfo() {
		return reserveInfo;
	}

	/**
	 * This method is to get start date of this order
	 * 
	 * @return start date of this order
	 */
	public LocalDateTime getStart() {
		return start;
	}

	/**
	 * This method is to add a Food Dish item to this order
	 * @param item Food Dish to add into Order
	 * @return A message about status of this method to system
	 */
	public String addDishItem(FoodDish item) {
		if (fdItems.add(item))
			return "Item added successfully";
		else
			return "Item already exist";
	}
	
	/**
	 * This method is to get the table object
	 * @return Table for the current order object
	 */
	public Table getTable() {
		return table;
	}
	
	/**
	 * This method is to remove a Food Dish item to this order
	 * @param item Dish to remove from Order
	 * @return a message about status of this method to system
	 */
	public String removeDishItem(FoodDish item) {
		if (fdItems.remove(item))
			return "Item remove successfully";
		else
			return "This item does not exist in this order";
	}

	/**
	 * This method is to add a Package item to this order
	 * @param item Set Package to add into Order
	 * @return a message about status of this method to system
	 */
	public String addPackItem(SetPackage item) {
		if (packItems.add(item))
			return "Item added successfully";
		else
			return "Item already exist";
	}

	/**
	 * This method is to remove a Package item to this order
	 * @param item Set Package to remove from Order
	 * @return a message about status of this method to system
	 */
	public String removePackItem(SetPackage item) {
		if (packItems.remove(item))
			return "Item remove successfully";
		else
			return "This item does not exist in this order";
	}

	/**
	 * This method is to get the current total price of this order
	 * 
	 * @return current total price of order
	 */
	public double totalPrice() {
		double totalPrice = 0;
		for (int i = 0; i < fdItems.size(); i++) {
			totalPrice += fdItems.get(i).getPrice();
		}
		for (int i = 0; i < packItems.size(); i++) {
			totalPrice += packItems.get(i).getPrice();
		}

		return totalPrice;
	}

	/**
	 * Returns GST based on total price
	 * @return GST of Order
	 */
	public double getGST() {
		return  0.07 * totalPrice();
	}
}
