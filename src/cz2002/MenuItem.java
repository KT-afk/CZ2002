package cz2002;

public class MenuItem {
	private String name;
	private String description;
	private double price;
	private boolean enabled;
	
	public MenuItem(String name, String description, double price)
	{
		this.enabled = true;
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
	public boolean toggleEnable() { enabled = !enabled; return enabled; }
	
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
	public boolean getEnabled() { return enabled; }
}
