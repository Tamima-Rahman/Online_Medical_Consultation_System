package dao;

import database.DBConnection;
import java.sql.*;

public class AppointmentDAO {

    Connection conn;

    public AppointmentDAO() {
        conn = DBConnection.getConnection();
    }

    // Book Appointment
    public void bookAppointment(
            String patientName,
            String doctorName,
            String date,
            String status
    ) {

        try {

        	String sql =
        			"INSERT INTO appointments(patient_name,doctor_name,appointment_date,status) VALUES(?,?,?,?)";

            PreparedStatement ps =conn.prepareStatement(sql);

            ps.setString(1, patientName);
            ps.setString(2, doctorName);
            ps.setString(3, date);
            ps.setString(4, status);

            ps.executeUpdate();

            System.out.println("Appointment Booked!");

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    // View Appointments
    public void viewAppointments() {

        try {

            String sql =
                    "SELECT * FROM appointments";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println(
                        rs.getInt("appointment_id")
                                + " | "
                                + rs.getString("patient_name")
                                + " | "
                                + rs.getString("doctor_name")
                                + " | "
                                +rs.getString("appointment_date")
                                + " | "
                                + rs.getString("status")
                );
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}