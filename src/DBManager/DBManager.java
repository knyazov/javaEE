package DBManager;

import Footballer.Footballer;
import Item.Item;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Item> allitems = new ArrayList<Item>();
    public static Long id = 6L;

    static {
        allitems.add(new Item(1L, "MacBook Pro 16", 2500));
        allitems.add(new Item(2L, "MacBook Pro 13", 1500));
        allitems.add(new Item(3L, "iPhone 13", 1200));
        allitems.add(new Item(4L, "iPhone 13 Pro Max", 1800));
        allitems.add(new Item(5L, "iPhone 12", 1000));
    }

    public static void addItem(Item item) {
        item.setId(id);
        allitems.add(item);
        id++;
    }

    public static ArrayList<Item> getAllitems() {
        return allitems;
    }

    private static ArrayList<Footballer> allfootballers = new ArrayList<Footballer>();

    static {
        allfootballers.add(new Footballer(1L, "Mbappe", "Kilian", 600000, "PSG", 70000000));
        allfootballers.add(new Footballer(2L, "Pele", "Senior", 7000000, "Brazil", 90000000));
        allfootballers.add(new Footballer(3L, "Messi", "Leo", 600000, "PSG", 950000000));
        allfootballers.add(new Footballer(4L, "Cristiano", "Ronaldo", 600000, "Man UTD", 80000000));
        allfootballers.add(new Footballer(5L, "Cristiano", "Ronaldo", 600000, "Man UTD", 80000000));
    }

    public static void addFootballer(Footballer footballer) {
        footballer.setId(id);
        allfootballers.add(footballer);
        id++;
    }

    public static ArrayList<Footballer> getFootballers() {
        return allfootballers;
    }

    public static Footballer getEachFootballer(Footballer footballer) {
        for (Footballer f :
                allfootballers) {
            if (f.getId() == footballer.getId()) {
                return f;
            }
        }
        return null;
    }

}
