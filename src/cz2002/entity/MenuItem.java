package cz2002.entity;

public class MenuItem {
	private String name;
	private String description;
	private double price;
	private boolean enabled;
	
	public MenuItem(String name, String description, double price)
	{
		this.name = name;
		this.description = description;
		this.price = price;
		this.enabled = true;
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
	public boolean toggleEnable()
	{
		enabled = !enabled;
		return enabled;
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
	public boolean getEnabled()
	{
		return enabled;
	}
}
