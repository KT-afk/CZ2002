package cz2002.system;

import cz2002.entity.Order;
import cz2002.entity.SaleRevenue;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class SaleRevenueSystem {

	public SaleRevenue generateSaleRevenueRep(Date start, Date end) {
		ArrayList<Order> orderListIncluded = new ArrayList<>();
		var orderList = OrderSystem.getOrderList();
		double totalPrice=0;
		//suppose OrderList is where we store all orders
		for(Order order : orderList) {
			Date orderDate = Timestamp.valueOf(order.getStart());
			if(!(start.before(orderDate) || end.after(orderDate))) {
				orderListIncluded.add(order);
			}
		}
		return new SaleRevenue(orderListIncluded, totalPrice);
	}
}
