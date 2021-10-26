package cz2002;

public class Table {
	private int Capacity;
	private String Status = "vacant";
	public Table(int capacity)
	{
		if(capacity <= 10 && capacity >= 2)
			Capacity = capacity;
		else
			System.out.println("Invalid Capacity");
	}
	public int getCapacity()
	{
		return Capacity;
	}
	public String getStatus()
	{
		return Status;
	}
	public boolean reserveTable(int noOfPeople)
	{
		if(noOfPeople <= Capacity)
		{
			Status = "occupied";
			return true;
		}
		else 
			return false;
			
	}
	public void removeBooking()
	{
		Status = "vacant";
	}
	
}
