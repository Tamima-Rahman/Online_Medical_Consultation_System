package database;

import java.sql.*;


public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/medical_system";

    private static final String USER = "root";
    private static final String PASSWORD = "MySql Password";

    public static Connection getConnection() {

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("Database Connected Successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver Error");

        } catch (SQLException e) {
            System.out.println("Connection Error");
        }

        return conn;
    }
}