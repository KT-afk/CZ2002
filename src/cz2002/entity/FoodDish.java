package cz2002.entity;

public class FoodDish extends MenuItem {
	public enum menuItemType
	{
		MAIN_COURSE,
		DRINKS,
		DESERT
	}
	
	private menuItemType type;
	
	public FoodDish(String name, String description, double price, menuItemType type)
	{
		super(name, description, price);
		this.type = type;
	}
	
	public void setType(menuItemType newType)
	{
		type = newType;
	}
	public menuItemType getType()
	{
		return type;
	}
}
