package com.medvault.auth.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "patient_consents",
       uniqueConstraints = @UniqueConstraint(columnNames = {"patient_user_id", "professional_user_id"}))
public class PatientConsent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ patient_user_id
    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_user_id", nullable = false)
    private User patient;

    // ✅ professional_user_id
    @ManyToOne(optional = false)
    @JoinColumn(name = "professional_user_id", nullable = false)
    private User professional;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConsentStatus status = ConsentStatus.PENDING;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    // ✅ GETTERS + SETTERS (IMPORTANT)

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getPatient() { return patient; }
    public void setPatient(User patient) { this.patient = patient; }

    public User getProfessional() { return professional; }
    public void setProfessional(User professional) { this.professional = professional; }

    public ConsentStatus getStatus() { return status; }
    public void setStatus(ConsentStatus status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
