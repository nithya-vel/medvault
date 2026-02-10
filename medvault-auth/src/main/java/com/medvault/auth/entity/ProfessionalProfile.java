package com.medvault.auth.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "professional_profiles")
public class ProfessionalProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name="user_id", nullable=false, unique=true)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private ProfessionalType type; // DOCTOR / HOSPITAL

    @Column(nullable=false)
    private String displayName; // doctor name or hospital name

    private String specialization; // only doctor
    private String licenseNumber;  // doctor/hospital registration
    private String phone;
    private String address;

    // getters/setters
 // ===== ID =====
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ===== USER =====
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // ===== DISPLAY NAME =====
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    // ===== PHONE =====
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // ===== ADDRESS =====
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // ===== SPECIALIZATION =====
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // ===== LICENSE NUMBER =====
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    // ===== TYPE =====
    public ProfessionalType getType() {
        return type;
    }

    public void setType(ProfessionalType type) {
        this.type = type;
    }

}
