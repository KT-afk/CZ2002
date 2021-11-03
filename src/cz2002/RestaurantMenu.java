package cz2002;

import java.util.ArrayList;

public class RestaurantMenu {
	// [TODO] getAlaCarteMenu but with option to show disabled? + encapsulation
	public ArrayList<FoodDish> alaCarteMenu;
	public ArrayList<SetPackage> setPackageMenu;
	
	public RestaurantMenu()
	{
		alaCarteMenu = new ArrayList<FoodDish>();
		setPackageMenu = new ArrayList<SetPackage>();
	}
	
//	public void addAlaCarte(FoodDish food)
//	{
//		alaCarteMenu.add(food);
//	}
//	public void addSetPackage(SetPackage set)
//	{
//		setPackageMenu.add(set);
//	}
}
