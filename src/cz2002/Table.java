package cz2002;

import java.util.ArrayList;

public class Table {
	private int tableNo;
	private int Capacity;
	private String Status = "vacant";
	//occupyingType can be reservation, walkin or 
	private String occupyingType = "Nil";
	
	public Table(int capacity, int tableNo)
	{
		if(capacity <= 10 && capacity >= 2)
			Capacity = capacity;
		else
			System.out.println("Invalid Capacity");
		this.tableNo = tableNo;
	}
	public int getCapacity()
	{
		return Capacity;
	}
	public String getStatus()
	{
		return Status;
	}
	public int getTableNo()
	{
		return tableNo;
	}
	public void freeTable()
	{
		Status = "vacant";
	}
	public void reserveTable(String occupyingType)
	{
		//Assuming that reservation system has checked the table and ensured that its free
		Status = "occupied";
		this.occupyingType = occupyingType;
	}
	
}
