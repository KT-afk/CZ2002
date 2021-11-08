package cz2002.ui;

import cz2002.system.ReservationSystem;
import cz2002.system.TableSystem;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RestaurantUI {

    private Scanner sc;
    private ReservationSystem reservationSystem;
    private TableSystem tableSystem;

    public RestaurantUI(ReservationSystem reservationSystem, TableSystem tableSystem, Scanner scanner) {
        this.reservationSystem = reservationSystem;
        this.tableSystem = tableSystem;
        sc = scanner;
    }

    // Check if Table is "vacant" and if is free for the next 1.5 hours (TableSystem
    // and ReservationSystem)
    public void checkTableAvailability() {
        var vacantTables = tableSystem.getAvailableTables();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.printf("The current time is %s\n", LocalTime.now().format(formatter));
        System.out.println("The following tables are currently available:");

        for(var table : vacantTables) {
            LocalTime upcomingReservation = reservationSystem.getUpcomingReservation(table.getTableNo());

            System.out.printf("  - Table #%-2d for %d pax", table.getTableNo(), table.getCapacity());

            if(upcomingReservation != null) {
                System.out.printf(" Available until %s", upcomingReservation.toString());
            }

            System.out.println();
        }

        System.out.println();
    }
}
