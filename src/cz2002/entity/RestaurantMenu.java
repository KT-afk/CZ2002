package cz2002.entity;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RestaurantMenu implements Serializable {
	public ArrayList<FoodDish> alaCarteMenu;
	public ArrayList<SetPackage> setPackageMenu;
	
	public RestaurantMenu()
	{
		alaCarteMenu = new ArrayList<FoodDish>();
		setPackageMenu = new ArrayList<SetPackage>();

		load();
	}

	public void save() {
		try {
			FileOutputStream f = new FileOutputStream("menu.dat");
			ObjectOutputStream out = new ObjectOutputStream(f);
			out.writeObject(this);
			out.flush();
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void load() {
		File f = new File("menu.dat");
		if(f.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
				var menu = (RestaurantMenu) ois.readObject();
				this.alaCarteMenu = menu.alaCarteMenu;
				this.setPackageMenu = menu.setPackageMenu;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
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
