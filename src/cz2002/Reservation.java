package cz2002;

import java.time.Duration;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

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
	public Table getTable()
	{
		return table;
	}
	public void deleteReservation()
	{
		name = "";
		noOfPax = 0;
		contact = "";
		date = null;
	}
	public Customer getCustomer()
	{
		return customer;
	}
	
}
