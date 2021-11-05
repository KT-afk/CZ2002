package cz2002.ui;

import cz2002.entity.Table;
import cz2002.system.ReservationSystem;
import cz2002.system.TableSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantUI {

    private Scanner sc;

    public RestaurantUI(Scanner scanner) {
        sc = scanner;
    }

    public List<Table> createMockTable() {
        ArrayList<Table> tables = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            Table table = new Table(2, i);
            tables.add(table);
        }

        return tables;
    }

    // Check if Table is "vacant" and if is free for the next 1.5 hours (TableSystem and ReservationSystem)
    public void checkTableAvailability(List<Table> tables) {
        ReservationSystem reservationSystem = new ReservationSystem();

        var vacantTables = tables.stream()
                                .filter(table -> table.getStatus() == "vacant")
                                .filter(table -> reservationSystem.checkTableForReservation(table.getTableNo()))
                                .toList();

        System.out.println("The following tables are currently available:");
    }
}
