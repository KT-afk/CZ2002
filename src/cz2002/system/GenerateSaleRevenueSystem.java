package cz2002.system;

import cz2002.entity.Order;
import cz2002.entity.Table;

import java.util.*;

public class GenerateSaleRevenueSystem{
	public class RevenueData{
		private ArrayList<Order> orderList;
		private double totalPrice;
		public RevenueData(ArrayList<Order> orderList,double totalPrice) {
			this.orderList = orderList;
			this.totalPrice = totalPrice;
		}
		public ArrayList<Order> getOrderList(){
			return orderList;
		}
		public double getTotalPrice() {
			return totalPrice;
		}
	}
//	public RevenueData generateSaleRevenueRep(Date start, Date end) {
//		ArrayList<Order> orderListIncluded;
//		double totalPrice=0;
//		//suppose OrderList is where we store all orders
//		for(int i=0;OrderList.size();i++) {
//			if(!start.after(OrderList.get(i).start) && !end.before(OrderList.get(i).end)) {
//				orderListIncluded.add(OrderList.get(i));
//				totalPrice+=OrderList.get(i).totalPrice();
//			}
//		}
//		return new RevenueData(orderListIncluded,totalPrice);
//	}
//	public ArrayList<Table> checkTablesAvailability(){
//		Arraylist<Table> availableTable;
//		for(int i=0; i<TableList.size();i++) {
//			if(TableList.get(i).status =="vacant"){
//				availableTable.add(TableList.get(i));
//			}
//		}
//		return availableTable;
//	}
}