package com.medvault.auth.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "patient_profiles")
public class PatientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    private String phone;
    private String gender;
    private String address;

    @Column(name = "blood_group")
    private String bloodGroup;

    private LocalDate dob;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    // ✅ Getters
    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getPhone() { return phone; }
    public String getGender() { return gender; }
    public String getAddress() { return address; }
    public String getBloodGroup() { return bloodGroup; }
    public LocalDate getDob() { return dob; }
    public User getUser() { return user; }

    // ✅ Setters (THE ONES YOUR CODE NEEDS)
    public void setId(Long id) { this.id = id; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setGender(String gender) { this.gender = gender; }
    public void setAddress(String address) { this.address = address; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
    public void setDob(LocalDate dob) { this.dob = dob; }
    public void setUser(User user) { this.user = user; }
}
