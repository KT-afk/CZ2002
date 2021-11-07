package cz2002.ui;

import cz2002.entity.FoodDish;
import cz2002.entity.MenuItem;
import cz2002.util.ScannerUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public abstract class MenuManager {

    protected Scanner sc;
    protected List<MenuItem> menu;

    private String format = "";
    private String[] headers = {};

    public MenuManager(Scanner scanner, List<? extends MenuItem> restaurantMenu) {
        sc = scanner;
        menu = (List<MenuItem>) restaurantMenu;
    }

    public void setFormatting(String format, String... headers) {
        this.format = format;
        this.headers = headers;
    }

    abstract void createMenuItem();
    abstract void editMenuItem(MenuItem item);

    public void run(String title) {

        boolean running = true;

        while (running) {
            printMenu();
            int option = ScannerUtil.Prompt(sc, "Create " + title, "Edit " + title, "Remove " + title, "Exit");

            switch (option) {
                case 1 -> createMenuItem();
                case 2 -> selectEditMenuItem();
                case 3 -> selectRemoveMenuItem();
                case 4 -> running = false;
            }
        }
    }

    protected void selectEditMenuItem() {
        while (true) {
            String[] menuItems = menu.stream().map(item -> item.toString()).toArray(String[]::new);
            String[] optionSelection = Stream.concat(Arrays.stream(menuItems), Arrays.stream(new String[]{"Back "})).toArray(String[]::new);
            String prompt = "Please select item to edit\n " + String.format(format + "\n", headers) + "=".repeat(55) + "";

            int option = ScannerUtil.CustomPrompt(sc, prompt, optionSelection);

            if (option <= menuItems.length) {
                editMenuItem(menu.get(option - 1));
            } else {
                break;
            }
        }
    }

    protected void selectRemoveMenuItem() {
        while (true) {
            String[] menuItems = menu.stream().map(item -> item.toString()).toArray(String[]::new);
            String[] optionSelection = Stream.concat(Arrays.stream(menuItems), Arrays.stream(new String[] { "Back "})).toArray(String[]::new);
            String prompt = "Please select item to remove\n " + String.format(format + "\n", headers) + "=".repeat(55) + "";

            int option = ScannerUtil.CustomPrompt(sc, prompt, optionSelection);

            if (option <= menuItems.length) {
                MenuItem item = menu.get(option - 1);
                item.toggleEnable();
            } else {
                break;
            }
        }
    }

    protected void printMenu() {
        System.out.println("\nContents of Restaurant Menu Dishes: ");
        System.out.printf(format + "\n", headers);
        System.out.println("=".repeat(55));

        if(!menu.isEmpty()) {
            int i = 1;
            for(MenuItem item : menu) {
                System.out.printf("%d) %s\n", i++, item.toString());
            }
        } else  {
            System.out.println("-- No Dishes --");
        }
    }
}