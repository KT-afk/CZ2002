package cz2002;

import java.util.ArrayList;

public class SetPackage extends MenuItem{
	private ArrayList<FoodDish> listOfDishes;
	
	public SetPackage(String name, String description, double price)
	{
		super(name, description, price);
		listOfDishes = new ArrayList<FoodDish>();
	}
	
	public void addFood(FoodDish food)
	{
		listOfDishes.add(food);
	}

	public void removeFood(FoodDish food)
	{
		listOfDishes.remove(food);
	}

	public ArrayList<FoodDish> getPackageItems()
	{
		return listOfDishes;
	}

	@Override
	public String toString() {
		return String.format("%6s %-20s $%.2f", getEnabled() ? "[ ]": "[*]", getName(), getPrice());
	}
}
