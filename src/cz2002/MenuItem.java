package cz2002;

public class MenuItem {
	private String name;
	private String description;
	private double price;
	
	public MenuItem(String name, String description, double price)
	{
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public void setName(String newName)
	{
		name = newName;
	}
	public void setDescription(String newDesc)
	{
		description = newDesc;
	}
	public void setPrice(double newPrice)
	{
		price = newPrice;
	}
	
	public String getName()
	{
		return name;
	}
	public String getDescription()
	{
		return description;
	}
	public double getPrice()
	{
		return price;
	}
}
