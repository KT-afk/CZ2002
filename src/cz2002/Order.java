import java.util.ArrayList;

public class Order{
	private Staff creator;
	private ArrayList<MenuItem> orderItems;
	private Reservation reserveInfo;
	public Order(Staff creator, Array<MenuItem> orderItems, Reservation reserveInfo ) {
		this.creator = creator;
		this.orderItems = orderItems;
		this.reserveInfo = reserveInfo;
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
	public String addItem(MenuItem item) {
		if(orderItems.add(item)) return "Item added successfully";
		else return "Item already exist";
	}
	public String removeItem(MenuItem item) {
		if(orderItems.remove(item)) return "Item remove successfully";
		else return "This item does not exist in this order";
	}
	
}