package cz2002.entity;

import java.util.ArrayList;
import java.util.Date;

public class Order{
	public static Integer OrderIDCounter =0;
	private Integer id;
	private Staff creator;
	private ArrayList<MenuItem> orderItems;
	private Reservation reserveInfo;
	private Table table;
	private Date start, end;
	public Order(Staff creator, ArrayList<MenuItem> orderItems, Reservation reserveInfo,Table table, Date start, Date end ) {
		id = OrderIDCounter++;
		this.creator = creator;
		this.orderItems = orderItems;
		this.reserveInfo = reserveInfo;
		this.table = table;
		this.start = start;
		this.end = end;
	}
	public Integer getID(){
		return id;
	}
	public Staff getCreator() {
		return creator;
	}
	public ArrayList<MenuItem> getOrderItems(){
		return orderItems;
	}
	public Reservation getReserveInfo() {
		return reserveInfo;
	}
	public Date getStart(){
		return start;
	}
	public Date getEnd(){
		return end;
	}
	public int getDuration(){
		return (int) ((start.getTime() - end.getTime()) / (1000.0f * 60.0f));
	}
	public String addItem(MenuItem item) {
		if(orderItems.add(item)) return "Item added successfully";
		else return "Item already exist";
	}
	public String removeItem(MenuItem item) {
		if(orderItems.remove(item)) return "Item remove successfully";
		else return "This item does not exist in this order";
	}
	public double totalPrice(){
		double totalPrice =0;
		for(int i=0;i<orderItems.size();i++){
			totalPrice+=orderItems.get(i).getPrice();
		}
		return totalPrice;
	}
}
