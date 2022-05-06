package knyazzov.akzhol.first.db;

import knyazzov.akzhol.first.model.Item;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Item> allitems = new ArrayList<Item>();
    public static Long id = 6L;
    static {
        allitems.add(new Item(1L,"MacBook Pro 16", 2500));
        allitems.add(new Item(2L,"MacBook Pro 13", 1500));
        allitems.add(new Item(3L,"iPhone 13", 1200));
        allitems.add(new Item(4L,"iPhone 13 Pro Max", 1800));
        allitems.add(new Item(5L,"iPhone 12", 1000));
    }
    public static void addItem(Item item){
        item.setId(id);
        allitems.add(item);
        id++;
    }

    public static ArrayList<Item> getAllitems(){
        return allitems;
    }
}
