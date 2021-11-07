package cz2002.system;

import cz2002.entity.Order;
import cz2002.entity.Table;

import java.time.LocalDate;
import java.util.*;

public class SaleRevenueSystem {
	public class SaleRevenue{
		private ArrayList<Order> orderList;
		private double totalPrice;
		public SaleRevenue(ArrayList<Order> orderList,double totalPrice) {
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

	public SaleRevenue generateSaleRevenueRep(Date start, Date end) {
		ArrayList<Order> orderListIncluded = new ArrayList<>();
		var orderList = OrderSystem.getOrderList();
		double totalPrice=0;
		//suppose OrderList is where we store all orders
		for(Order order : orderList) {
			Date orderDate = order.getStart();
			if(!(start.before(orderDate) || end.after(start))) {
				orderListIncluded.add(order);
			}
		}
		return new SaleRevenue(orderListIncluded, totalPrice);
	}
}
