package presents;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Presents {

    private static String dbhost = "jdbc:mysql://localhost:3306/app?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "root";

    public static void main(String[] args) {
        new AddPersonFrame().setVisible(true);
    }

}
