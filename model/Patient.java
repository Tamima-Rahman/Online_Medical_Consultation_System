package model;

public class Patient extends User {

    private int age;
    private String gender;

    public Patient() {
    }

    public Patient(
            int id,
            String name,
            String email,
            String password,
            String role,
            int age,
            String gender
    ) {

        super(id, name, email, password, role);

        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void displayMenu() {

  
    }
}