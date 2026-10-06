package model;

public class Admin extends User {

    public Admin() {
    }

    public Admin(
            int id,
            String name,
            String email,
            String password,
            String role
    ) {

        super(id, name, email, password, role);
    }

    @Override
    public void displayMenu() {

        System.out.println("\n===== ADMIN MENU =====");
        System.out.println("1. Add Doctor");
        System.out.println("2. View Users");
        System.out.println("3. Logout");
    }
}