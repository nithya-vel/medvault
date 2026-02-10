package com.medvault.auth.service;

import com.medvault.auth.entity.*;
import com.medvault.auth.repository.PatientConsentRepository;
import com.medvault.auth.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ConsentService {

    private final PatientConsentRepository consentRepo;
    private final UserRepository userRepo;

    public ConsentService(PatientConsentRepository consentRepo, UserRepository userRepo) {
        this.consentRepo = consentRepo;
        this.userRepo = userRepo;
    }

    @Transactional
    public PatientConsent requestConsent(String patientEmail, String professionalEmail) {

        if (patientEmail == null || patientEmail.isBlank()) {
            throw new RuntimeException("Patient email missing (token not read properly)");
        }
        if (professionalEmail == null || professionalEmail.isBlank()) {
            throw new RuntimeException("Professional email is required");
        }

        User patient = userRepo.findByEmail(patientEmail)
                .orElseThrow(() -> new RuntimeException("Patient not found: " + patientEmail));

        User professional = userRepo.findByEmail(professionalEmail)
                .orElseThrow(() -> new RuntimeException("Professional not found: " + professionalEmail));

        if (patient.getRole() != Role.PATIENT) {
            throw new RuntimeException("Only PATIENT can request consent");
        }

        if (professional.getRole() != Role.DOCTOR && professional.getRole() != Role.HOSPITAL) {
            throw new RuntimeException("Consent can be requested only for DOCTOR/HOSPITAL");
        }

        PatientConsent consent = consentRepo
                .findByPatient_EmailAndProfessional_Email(patientEmail, professionalEmail)
                .orElseGet(PatientConsent::new);

        consent.setPatient(patient);
        consent.setProfessional(professional);

        // keep it always pending on request (even if old record exists)
        consent.setStatus(ConsentStatus.PENDING);
        consent.setUpdatedAt(LocalDateTime.now());

        return consentRepo.save(consent);
    }

    @Transactional
    public PatientConsent grantConsent(String professionalEmail, String patientEmail) {

        if (professionalEmail == null || professionalEmail.isBlank()) {
            throw new RuntimeException("Professional email missing (token not read properly)");
        }
        if (patientEmail == null || patientEmail.isBlank()) {
            throw new RuntimeException("Patient email is required");
        }

        PatientConsent consent = consentRepo
                .findByPatient_EmailAndProfessional_Email(patientEmail, professionalEmail)
                .orElseThrow(() -> new RuntimeException("No consent request found"));

        consent.setStatus(ConsentStatus.GRANTED);
        consent.setUpdatedAt(LocalDateTime.now());
        return consentRepo.save(consent);
    }

    @Transactional
    public PatientConsent revokeConsent(String professionalEmail, String patientEmail) {

        if (professionalEmail == null || professionalEmail.isBlank()) {
            throw new RuntimeException("Professional email missing (token not read properly)");
        }
        if (patientEmail == null || patientEmail.isBlank()) {
            throw new RuntimeException("Patient email is required");
        }

        PatientConsent consent = consentRepo
                .findByPatient_EmailAndProfessional_Email(patientEmail, professionalEmail)
                .orElseThrow(() -> new RuntimeException("No consent found"));

        consent.setStatus(ConsentStatus.REVOKED);
        consent.setUpdatedAt(LocalDateTime.now());
        return consentRepo.save(consent);
    }

    public boolean hasGrantedConsent(String patientEmail, String professionalEmail) {

        if (patientEmail == null || professionalEmail == null) return false;

        return consentRepo.findByPatient_EmailAndProfessional_Email(patientEmail, professionalEmail)
                .map(c -> c.getStatus() == ConsentStatus.GRANTED)
                .orElse(false);
    }
}
