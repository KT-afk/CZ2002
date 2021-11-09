package cz2002.system;

import cz2002.entity.Table;

import java.util.ArrayList;
import java.util.List;

public class TableSystem {

    public List<Table> getTables() {
        return new ArrayList<>();
    }

    public static List<Table> CreateMockTableList() {
        ArrayList<Table> tables = new ArrayList<>();
        int capacity = 2;

        for(int i = 0; i < 10; i++) {
            Table table = new Table(capacity++, i);
            tables.add(table);

            if(capacity >= 10)
                capacity = 2;
        }

        return tables;
    }
}
