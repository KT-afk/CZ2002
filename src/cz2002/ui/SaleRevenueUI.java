package cz2002.ui;

import cz2002.entity.MenuItem;
import cz2002.entity.Order;
import cz2002.entity.SaleRevenue;
import cz2002.system.SaleRevenueSystem;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class SaleRevenueUI {
    private Scanner sc;
    private SaleRevenueSystem saleRevenueSystem;

    public SaleRevenueUI(SaleRevenueSystem saleRevenueSystem, Scanner scanner) {
        saleRevenueSystem = saleRevenueSystem;
        sc = scanner;
    }

    public void printSaleRevenueReport() {
        Date startDate = promptDate("Please enter start period");
        Date endDate = promptDate("Please enter end period");

        System.out.println("=".repeat(30));
        System.out.println("\nSale Revenue Report\n");
        System.out.printf("Start Period: %s\n", startDate.toString());
        System.out.printf("End Period: %s\n", endDate.toString());

        printSaleRevenue(saleRevenueSystem.generateSaleRevenueRep(startDate, endDate));
    }

    public void printSaleRevenue(SaleRevenue saleRevenue) {
        var orderList = saleRevenue.getOrderList();

        for(Order order : orderList) {
            printOrder(order);
        }

        System.out.printf("\nTotal Revenue: %.2f", saleRevenue.getTotalPrice());
    }

    private void printOrder(Order order) {
        System.out.printf("[%s] Order #%-2d - $%.2f\n", order.getStart(), order.getID(), order.totalPrice());
        for(MenuItem menuItem : order.getPackItems())
            printMenuItem(menuItem);

        for(MenuItem menuItem : order.getDishItems())
            printMenuItem(menuItem);
    }

    private void printMenuItem(MenuItem menuItem) {
        System.out.printf(" - %-10s\n", menuItem.getName());
    }

    private Date promptDate(String prompt) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        while(true) {
            try {
                System.out.printf("%s (dd/MM/yyyy): ", prompt);
                return formatter.parse(sc.nextLine());
            } catch (Exception e) {
                System.out.println("You have entered an invalid date");
            }
        }
    }
}