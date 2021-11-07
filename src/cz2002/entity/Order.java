package cz2002.entity;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order{
	public static Integer OrderIDCounter =0;
	private Integer id;
	private Staff creator;
	private ArrayList<FoodDish> fdItems;
	private ArrayList<SetPackage> packItems;
	private Reservation reserveInfo;
	private Table table;
	private LocalDateTime start;;
	public Order(Staff creator, ArrayList<FoodDish> fdItems, ArrayList<SetPackage> packItems, Reservation reserveInfo,Table table, LocalDateTime start) {
		id = OrderIDCounter++;
		this.creator = creator;
		this.fdItems = fdItems;
		this.packItems = packItems;
		this.reserveInfo = reserveInfo;
		this.table = table;
		this.start = start;
	}
	public Integer getID(){
		return id;
	}
	public Staff getCreator() {
		return creator;
	}
	public ArrayList<FoodDish> getDishItems(){
		return fdItems;
	}
	public ArrayList<SetPackage> getPackItems() {
		return packItems;
	}
	public Reservation getReserveInfo() {
		return reserveInfo;
	}
	public LocalDateTime getStart(){
		return start;
	}
	public String addDishItem(FoodDish item) {
		if(fdItems.add(item)) return "Item added successfully";
		else return "Item already exist";
	}
	public String removeDishItem(FoodDish item) {
		if(fdItems.remove(item)) return "Item remove successfully";
		else return "This item does not exist in this order";
	}
	public String addPackItem(SetPackage item) {
		if(packItems.add(item)) return "Item added successfully";
		else return "Item already exist";
	}
	public String removePackItem(SetPackage item) {
		if(packItems.remove(item)) return "Item remove successfully";
		else return "This item does not exist in this order";
	}
	public double totalPrice(){
		double totalPrice =0;
		for(int i=0;i<fdItems.size();i++){
			totalPrice+=fdItems.get(i).getPrice();
		}
		for(int i=0;i<packItems.size();i++){
			totalPrice+=packItems.get(i).getPrice();
		}
		return totalPrice;
	}
}
