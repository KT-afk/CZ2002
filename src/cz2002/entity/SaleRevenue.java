package cz2002.entity;

import java.util.ArrayList;

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