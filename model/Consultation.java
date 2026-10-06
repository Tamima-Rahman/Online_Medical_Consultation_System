package model;

public class Consultation {

    private int consultationId;
    private int appointmentId;
    private String diagnosis;
    private String prescription;

    public Consultation() {
    }

    public Consultation(
            int consultationId,
            int appointmentId,
            String diagnosis,
            String prescription
    ) {

        this.consultationId = consultationId;
        this.appointmentId = appointmentId;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }

    public int getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(int consultationId) {
        this.consultationId = consultationId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
}