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
	
	@Override
	public String toString() {
		String typeString = "";
		switch (type) {
			case MAIN_COURSE    -> typeString = "Main Course";
			case DESERT         -> typeString = "Desert";
			case DRINKS         -> typeString = "Drinks";
		}

		return String.format("%6s %-20s %-15s $%.2f", getEnabled() ? "[ ]": "[*]", getName(), typeString, getPrice());
	}
	
	public String customerToString() {
		String typeString = "";
		switch (type) {
			case MAIN_COURSE    -> typeString = "Main Course";
			case DESERT         -> typeString = "Desert";
			case DRINKS         -> typeString = "Drinks";
		}

		return String.format("%-20s %-20s $%-20.2f %-20s", getName(), typeString, getPrice(), getDescription());
	}
}
