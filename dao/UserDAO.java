package dao;

import database.DBConnection;
import java.sql.*;

public class UserDAO {

    Connection conn;

    public UserDAO() {
        conn = DBConnection.getConnection();
    }

    public void registerUser(String name, String email, String password, String role) {

        try {
            String sql = "INSERT INTO users(name,email,password,role) VALUES(?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, role);

            ps.executeUpdate();

            System.out.println("Registration Successful!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean loginUser(String email, String password) {

        boolean found = false;

        try {
            String sql = "SELECT * FROM users WHERE email=? AND password=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                found = true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return found;
    }
}