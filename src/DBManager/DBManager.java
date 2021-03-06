package DBManager;

import Footballer.Footballer;
import Item.*;

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


    protected static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee_db?useUnicode=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean addStudent(Students students) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO students (id, name, surname, birth_date, city, country_id)" +
                    "VALUES (NULL , ?, ?, ?, ?, ?)" +
                    "");

            statement.setString(1, students.getName());
            statement.setString(2, students.getSurname());
            statement.setString(3, students.getBirth_date());
            statement.setString(4, students.getCity());
            statement.setLong(5, students.getCountry().getId());

            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows > 0;
    }

    public static ArrayList<Students> getStudent() {
        ArrayList<Students> students = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT s.id, s.name, s.surname, s.birth_date, s.city, s.country_id, c.name AS countryName, c.code " +
                    "FROM students s " +
                    "INNER JOIN countries c ON s.country_id = c.id");


            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                students.add(new Students(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("birth_date"),
                        resultSet.getString("city"),
                        new Countries(
                                resultSet.getLong("country_id"),
                                resultSet.getString("countryName"),
                                resultSet.getString("code")
                        )
                ));

            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static Students getStudent(Long id) {
        Students student = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT s.id, s.name, s.surname, s.birth_date, s.city, s.country_id, c.name AS countryName, c.code" +
                    "FROM students s" +
                    "INNER JOIN countries c ON s.country_id = c.id" +
                    "where id = ? LIMIT 1");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                student = new Students(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("birth_date"),
                        resultSet.getString("city"),
                        new Countries(
                                resultSet.getLong("country_id"),
                                resultSet.getString("countryName"),
                                resultSet.getString("code")
                        )
                );

            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public static boolean editStudent(Students students) {
        int row = 0;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE students SET name = ?, surname = ?, birth_date = ?, city = ?, country_id = ?" +
                    "WHERE id = ?" +
                    "");

            statement.setString(1, students.getName());
            statement.setString(2, students.getSurname());
            statement.setString(3, students.getBirth_date());
            statement.setString(4, students.getCity());
            statement.setLong(5,students.getCountry().getId());
            statement.setLong(6, students.getId());


            row = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return row > 0;
    }

    public static boolean deleteStudent(Students students) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM students WHERE id = ?" +
                    "");

            statement.setLong(1,students.getId());

            rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows > 0;
    }

    public static ArrayList<News> getNews() {
        ArrayList<News> news = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT id, header, content, author, type " +
                    "FROM news" +
                    "");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                news.add(new News(
                        resultSet.getLong("id"),
                        resultSet.getString("header"),
                        resultSet.getString("content"),
                        resultSet.getString("author"),
                        resultSet.getString("type")
                ));
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return news;
    }

    public static boolean addNews(News news) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO news (id, header, content, author, type)" +
                    "VALUES (NULL, ?, ?, ?, ?)" +
                    "");

            statement.setString(1, news.getHeader());
            statement.setString(2, news.getContent());
            statement.setString(3, news.getAuthor());
            statement.setString(4, news.getType());

            rows = statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows > 0;
    }

    public static ArrayList<Countries> getCountries(){
        ArrayList<Countries> countries = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM countries" +
                    "");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                countries.add(new Countries(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("code")
                ));
            }
            statement.close();



        }catch (Exception e){
            e.printStackTrace();
        }

        return countries;
    }

    public static Countries getCountry(Long id){
        Countries countries = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM countries WHERE id = ? LIMIT 1" +
                    "");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){
            countries = new Countries(
              resultSet.getLong("id"),
              resultSet.getString("name"),
              resultSet.getString("code")
            );
        }
        statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return countries;
    }
}