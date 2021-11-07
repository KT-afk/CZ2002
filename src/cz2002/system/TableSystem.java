package cz2002.system;

import cz2002.entity.Table;

import java.util.ArrayList;
import java.util.List;

public class TableSystem {
	public static int tableCounter=0;
	private ArrayList<Table> tableList = new ArrayList<Table>();

	public ArrayList<Table> getTableList() {
		return tableList;
	}
	public String addTable(int capacity) {
		if(capacity<2 || capacity>10) return "Invalid capacity!";
		Table table = new Table(capacity, ++tableCounter);
		if(tableList.add(table)) return "Table added successfully!";
		else return "Failed to add table!";
	}
	public String removeTable(int tableNo) {
		if(tableList.removeIf(table-> table.getTableNo() == tableNo))
			return "Table removed successfully!";

		return "Failed to removed table";
	}

	public ArrayList<Table> getAvailableTables(){
		ArrayList<Table> availableTables=new ArrayList<Table>();
		for(int i=0;i<tableList.size();i++) {
			if(tableList.get(i).getStatus() == Table.Status.VACANT) {
				availableTables.add(tableList.get(i));
			}
		}
		return availableTables;
	}
	public Table getTableByNo(int tableNo) {
		for(int i=0;i<tableList.size();i++) {
			if(tableList.get(i).getTableNo() == tableNo) {
				return tableList.get(i);
			}
		}
		return null;
	}
}
