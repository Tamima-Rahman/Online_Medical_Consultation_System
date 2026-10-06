package dao;

import database.DBConnection;
import java.sql.*;

public class ConsultationDAO {

    Connection conn;

    public ConsultationDAO() {

        conn = DBConnection.getConnection();
    }

    // Add Consultation
    public void addConsultation(
            int appointmentId,
            String diagnosis,
            String prescription
    ) {

        try {

            String sql =
                    "INSERT INTO consultations(appointment_id, diagnosis, prescription) VALUES(?, ?, ?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, appointmentId);
            ps.setString(2, diagnosis);
            ps.setString(3, prescription);

            ps.executeUpdate();

            System.out.println("Consultation Added Successfully!");

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    // View Consultations
    public void viewConsultations() {

        try {

            String sql = "SELECT * FROM consultations";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== CONSULTATION LIST =====");

            while(rs.next()) {

                System.out.println(
                        rs.getInt("consultation_id")
                                + " | Appointment ID: "
                                + rs.getInt("appointment_id")
                                + " | Diagnosis: "
                                + rs.getString("diagnosis")
                                + " | Prescription: "
                                + rs.getString("prescription")
                );
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}