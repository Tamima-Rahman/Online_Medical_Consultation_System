package model;

public class Appointment {

    private int appointmentId;
    private String patientName;
    private String doctorName;
    private String date;
    private String status;

 
    public static int totalAppointments = 0;

   
    public final String hospitalName ="Smart Medical Center";

    public Appointment() {
        totalAppointments++;
    }

    public Appointment(
            int appointmentId,
            String patientName,
            String doctorName,
            String date,
            String status
    ) {

        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.status = status;

        totalAppointments++;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}