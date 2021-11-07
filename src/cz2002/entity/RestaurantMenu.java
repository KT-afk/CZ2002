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
	
	public void printAllMenu()
	{
		System.out.println("\nRestaurant Menu Promotion Packages: ");
        System.out.printf("   %-20s %-20s %-20s\n", "Name", "Price ($S)", "Description");
        System.out.println("=".repeat(55));
        if(!setPackageMenu.isEmpty()) {
            int i = 1;
            for(SetPackage item : setPackageMenu) {
                System.out.printf("%d) %s\n", i++, item.customerToString());
            }
        } else  {
            System.out.println("-- No Promotion Packages --");
        }
        
		System.out.println("\nRestaurant Menu Dishes: ");
		System.out.printf("   %-20s %-20s %-20s %-20s\n", "Name", "Type", "Price ($S)", "Description");
        System.out.println("=".repeat(80));
		
        if(!alaCarteMenu.isEmpty()) {
            int i = 1;
            for(FoodDish item : alaCarteMenu) {
                if (item.getEnabled())
                {
                	System.out.printf("%d) %s\n", i++, item.customerToString());
                }
            }
        } else  {
            System.out.println("-- No Dishes --");
        }
	}
}
