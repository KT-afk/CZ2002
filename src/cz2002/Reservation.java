package cz2002;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Reservation {

	private String name;
	private int noOfPax;
	private String contact;
	private Date date;
	private Customer customer;
	private Table table;
	
	private Reservation(String name, int noOfPax, String contact, Date date, Table table, Customer customer)
	{
		this.name = name;
		this.noOfPax = noOfPax;
		this.contact = contact;
		this.date = date;
		
	}
	public String getName()
	{
		return name;
	}
	public String getContact()
	{
		return contact;
	}
	public Date getDate()
	{
		return date;
	}
	public int noOfPax()
	{
		return noOfPax;
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
		
	}
	
}
