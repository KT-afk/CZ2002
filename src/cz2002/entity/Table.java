package cz2002.entity;

import cz2002.entity.Reservation;

import java.util.ArrayList;

public class Table {
	public enum Status {
		VACANT, OCCUPIED
	}

	private int tableNo;
	private int Capacity;
	private Status type = Status.VACANT;

	public Table(int capacity, int tableNo) {
		if (capacity <= 10 && capacity >= 2)
			Capacity = capacity;
		else
			System.out.println("Invalid Capacity");
		this.tableNo = tableNo;
	}

	public int getCapacity() {
		return Capacity;
	}

	public Status getStatus() {
		return type;
	}

	public int getTableNo() {
		return tableNo;
	}

	public void freeTable() {
		type = Status.VACANT;
	}

	public void reserveTable(String occupyingType) {
		// Assuming that reservation system has checked the table and ensured that its
		// free
		type = Status.OCCUPIED;
	}

}
