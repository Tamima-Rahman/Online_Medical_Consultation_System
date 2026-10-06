package model;

public class Doctor extends User {

    private String specialization;

    public Doctor() {
    }

    public Doctor(
            int id,
            String name,
            String email,
            String password,
            String role,
            String specialization
    ) {

        super(id, name, email, password, role);

        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void displayMenu() {

        System.out.println("\n===== DOCTOR MENU =====");
        System.out.println("1. View Appointments");
        System.out.println("2. Add Prescription");
        System.out.println("3. Logout");
    }
}