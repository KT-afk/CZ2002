package cz2002.system;

import cz2002.entity.Order;
import cz2002.entity.SaleRevenue;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * This is to manage Sale Revenue
 * @author Tran Trung Dung
 * @version 1.0
 * @since 2021-11-06
 */
public class SaleRevenueSystem {

	private OrderSystem orderSystem;
	public SaleRevenueSystem(OrderSystem orderSystem) {
		this.orderSystem = orderSystem;
	}

	/**
	 * This method is to generate Sale Revenue Report of a specific period
	 * @param start start date of this period
	 * @param end end date of this period
	 * @return a SaleRevenue object which contain all orders included in this period and total price of all orders
	 */
	public SaleRevenue generateSaleRevenueRep(Date start, Date end) {
		ArrayList<Order> orderListIncluded = new ArrayList<>();
		var orderList = orderSystem.getOrderList();
		double totalPrice=0;
		//suppose OrderList is where we store all orders
		for(Order order : orderList) {
			Date orderDate = Timestamp.valueOf(order.getStart());
			if(!(start.before(orderDate) || end.after(orderDate))) {
				orderListIncluded.add(order);
				totalPrice+=order.totalPrice();
			}
		}
		return new SaleRevenue(orderListIncluded, totalPrice);
	}
}
