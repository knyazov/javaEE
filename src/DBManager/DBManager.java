package DBManager;

import Footballer.Footballer;
import Item.Item;
import Item.News;
import Item.Students;

import java.sql.*;
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

    private static ArrayList<News> allnews = new ArrayList<News>();

    static {
        allnews.add(new News("The crazy way", "Last friday Disney", "Adam Holmes", "culture"));
        allnews.add(new News("GGG vs Canelo", "on Monte carlo", "tmt", "sport"));
        allnews.add(new News("Real Madrid vs Liverpool", "on May", "Howard Webb", "sport"));
        allnews.add(new News("Doctor Strange", "Last friday Disney", "Sam Rimey", "cinema"));
        allnews.add(new News("Spider Man", "MJ Watson Toby Mcguire", "Adam Holmes", "cinema"));
    }


    protected static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee_db?useUnicode=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean addStudent(Students students){
        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO students (id, name, surname, birth_date, city)" +
                    "VALUES (NULL , ?, ?, ?, ?)" +
                    "");

            statement.setString(1, students.getName());
            statement.setString(2, students.getSurname());
            statement.setString(3, students.getBirth_date());
            statement.setString(4, students.getCity());

            rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static ArrayList<Students> getStudent(){
        ArrayList<Students> students = new ArrayList<Students>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT id, name, surname, birth_date, city " +
                    "FROM STUDENTS");


            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                students.add(new Students(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("birth_date"),
                        resultSet.getString("city")
                ));

            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

    public static Students getStudent(Long id){
        Students student = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT id, name, surname, birth_date, city " +
                    "from STUDENTS where id = ? LIMIT 1");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                student = new Students(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("birth_date"),
                        resultSet.getString("city")
                );

            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }
}
