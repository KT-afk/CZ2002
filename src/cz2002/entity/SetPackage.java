package cz2002.entity;

import cz2002.entity.FoodDish;
import cz2002.entity.MenuItem;

import java.util.ArrayList;

public class SetPackage extends MenuItem {
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
	
	public String customerToString() {
		return String.format("%-20s $%-20.2f %-20s", getName(), getPrice(), getDescription());
	}
}
