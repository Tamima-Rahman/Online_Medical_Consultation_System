package dao;

import database.DBConnection;
import java.sql.*;

public class DoctorDAO {

    Connection conn;

    public DoctorDAO() {

        conn = DBConnection.getConnection();
    }

    // Add Doctor
    public void addDoctor(
            String doctorName,
            String specialization
    ) {

        try {

            String sql =
                    "INSERT INTO doctors(doctor_name, specialization) VALUES(?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, doctorName);
            ps.setString(2, specialization);

            ps.executeUpdate();

            System.out.println("Doctor Added Successfully!");

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    // View Doctors
    public void viewDoctors() {

        try {

            String sql = "SELECT * FROM doctors";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== DOCTOR LIST =====");

            while(rs.next()) {

                System.out.println(
                        rs.getInt("doctor_id")
                                + " | "
                                + rs.getString("doctor_name")
                                + " | "
                                + rs.getString("specialization")
                );
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}