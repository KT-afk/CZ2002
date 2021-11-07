package cz2002.entity;

import java.util.ArrayList;

public class RestaurantMenu {
	public ArrayList<FoodDish> alaCarteMenu;
	public ArrayList<SetPackage> setPackageMenu;
	
	public RestaurantMenu()
	{
		alaCarteMenu = new ArrayList<FoodDish>();
		setPackageMenu = new ArrayList<SetPackage>();
	}
	
	public void addAlaCarte(FoodDish food)
	{
		alaCarteMenu.add(food);
	}
	public void addSetPackage(SetPackage set)
	{
		setPackageMenu.add(set);
	}
}
