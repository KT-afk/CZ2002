package cz2002.system;

import cz2002.entity.Table;

import java.util.ArrayList;
import java.util.List;

public class TableSystem {
	public static int tableCounter=0;
	private static ArrayList<Table> tableList = new ArrayList<Table>();

	public static ArrayList<Table> getTableList() {
		return tableList;
	}
	public String addTable(int capacity) {
		if(capacity<2 || capacity>10) return "Invalid capacity!";
		Table table = new Table(capacity,++tableCounter);
		if(tableList.add(table)) return "Table added successfully!";
		else return "Failed to add table!";
	}
	public String removeTable(int tableNo) {
		tableList.map((table)->{
			if(table.tableNo == tableNo) {
				if(tableList.remove(table)) return "Table removed successfully!";
				else return "Failed to removed table";
			}
		});
		return "Invalid table number!";
	}
	public ArrayList<Table> CheckAvailability(){
		ArrayList<Table> availableTables=new ArrayList<Table>();
		for(int i=0;i<tableList.size();i++) {
			if(tableList.get(i).status == "vacant") {
				availableTables.add(tableList.get(i));
			}
		}
		return availableTables;
	}
	
}
	
}
