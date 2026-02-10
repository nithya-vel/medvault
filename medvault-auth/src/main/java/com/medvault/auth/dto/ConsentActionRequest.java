package com.medvault.auth.dto;

public class ConsentActionRequest {

    private String patientEmail; // doctor/hospital grants/revokes patient

    public ConsentActionRequest() {}

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }
}
