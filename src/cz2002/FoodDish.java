package cz2002;

public class FoodDish extends MenuItem{
	public enum Type
	{
		MAIN_COURSE,
		DRINKS,
		DESERT
	}
	
	private Type type;
	
	public FoodDish(String name, String description, double price, Type type)
	{
		super(name, description, price);
		this.type = type;
	}
	
	public void setType(Type newType)
	{
		type = newType;
	}
	public Type getType()
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


}
