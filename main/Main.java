package main;

import dao.*;
import model.*;
import thread.LoadingThread;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        LoadingThread t1 = new LoadingThread();
        t1.start();

        UserDAO userDAO = new UserDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        ConsultationDAO consultationDAO = new ConsultationDAO();

        int choice;

        do {
            System.out.println("\n===== SMART MEDICAL SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. View Doctors");
            System.out.println("6. Add Consultation");
            System.out.println("7. View Consultations");
            System.out.println("8. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // REGISTER
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Password: ");
                    String password = sc.nextLine();

                    System.out.print("Role (Admin/Doctor/Patient): ");
                    String role = sc.nextLine();

                    userDAO.registerUser(name, email, password, role);
                    break;

                // LOGIN
                case 2:
                    System.out.print("Email: ");
                    String loginEmail = sc.nextLine();

                    System.out.print("Password: ");
                    String loginPassword = sc.nextLine();

                    boolean login = userDAO.loginUser(loginEmail, loginPassword);

                    if (login) {
                        System.out.println("Login Successful!");

                        System.out.print("Enter Role Again: ");
                        String loginRole = sc.nextLine();

                        // ROLE BASED MENU
                        if (loginRole.equalsIgnoreCase("Admin")) {

                            Admin admin = new Admin();
                            admin.displayMenu();

                        } else if (loginRole.equalsIgnoreCase("Doctor")) {

                            Doctor doctor = new Doctor();
                            doctor.displayMenu();

                        } else if (loginRole.equalsIgnoreCase("Patient")) {

                            Patient patient = new Patient();
                            patient.displayMenu();

                        } else {
                            System.out.println("Invalid Role!");
                        }

                    } else {
                        System.out.println("Invalid Email or Password!");
                    }
                    break;

                // BOOK APPOINTMENT
                case 3:
                    System.out.print("Patient Name: ");
                    String patient = sc.nextLine();

                    System.out.print("Doctor Name: ");
                    String doctor = sc.nextLine();

                    System.out.print("Date: ");
                    String date = sc.nextLine();

                    appointmentDAO.bookAppointment(patient, doctor, date, "Pending");
                    break;

                // VIEW APPOINTMENTS
                case 4:
                    appointmentDAO.viewAppointments();
                    break;

                // VIEW DOCTORS
                case 5:
                    doctorDAO.viewDoctors();
                    break;

                // ADD CONSULTATION
                case 6:
                    System.out.print("Appointment ID: ");
                    int appointmentId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Diagnosis: ");
                    String diagnosis = sc.nextLine();

                    System.out.print("Prescription: ");
                    String prescription = sc.nextLine();

                    consultationDAO.addConsultation(appointmentId, diagnosis, prescription);
                    break;

                // VIEW CONSULTATIONS
                case 7:
                    consultationDAO.viewConsultations();
                    break;

                // EXIT
                case 8:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 8);
        sc.close();
    }
}