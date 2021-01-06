package presents;

import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Mysql {

    private static String dbhost = "jdbc:mysql://localhost:3306/app?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "root";
    Connection conn = null;
    ArrayList<Person> people = new ArrayList<Person>();

    public Mysql() {
    }

    public void addPerson(String name, String email) {

        try {
            conn = DriverManager.getConnection(dbhost, username, password);
            Statement s = (Statement) conn.createStatement();
            s.executeUpdate("INSERT INTO people (name, email) VALUES ('" + name + "','" + email + "')");

        } catch (SQLException e) {
            System.out.println("Cannot create database connection");
            e.printStackTrace();
        }
    }

    public ArrayList selectEverything() {

        try {
            conn = DriverManager.getConnection(dbhost, username, password);
            Statement s = (Statement) conn.createStatement();
            ResultSet result = s.executeQuery("SELECT * FROM people;");

            while (result.next()) {
                String name = result.getString("name");
                String email = result.getString("email");
                Person person = new Person(name, email);
                people.add(person);
            }
            return people;
        } catch (SQLException e) {
            System.out.println("Cannot create database connection");
            e.printStackTrace();
        }
        return null;
    }

}
