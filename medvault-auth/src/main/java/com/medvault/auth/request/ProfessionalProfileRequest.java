package com.medvault.auth.request;

import com.medvault.auth.entity.ProfessionalType;

public class ProfessionalProfileRequest {

    private String displayName;
    private String phone;
    private String address;
    private String specialization;
    private String licenseNumber;
    private ProfessionalType type;

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    public ProfessionalType getType() { return type; }
    public void setType(ProfessionalType type) { this.type = type; }
}
