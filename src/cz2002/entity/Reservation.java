package cz2002.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation implements Serializable{

	private String name;
	private int noOfPax;
	private String contact;
	private LocalDate date;
	private LocalTime time;
	private String customerId;
	private int tableNo;
	
	public Reservation(String name, int noOfPax, String contact, LocalDate date, LocalTime time, int tableNo, String customerId)
	{
		this.name = name;
		this.noOfPax = noOfPax;
		this.contact = contact;
		this.date = date;
		this.time = time;
		this.tableNo = tableNo;
		
	}
	public String getName()
	{
		return name;
	}
	public String getContact()
	{
		return contact;
	}
	public LocalDate getDate()
	{
		return date;
	}
	public LocalTime getTime()
	{
		return time;
	}
	public int getNoOfPax()
	{
		return noOfPax;
	}
	public int getTableNo()
	{
		return tableNo;
	}
//	public Table getTable()
//	{
//		return table;
//	}

//	public Customer getCustomer()
//	{
//		return customer;
//	}
	
}
