package com.medvault.auth.service;

import com.medvault.auth.entity.PatientProfile;
import com.medvault.auth.entity.ProfessionalProfile;
import com.medvault.auth.entity.User;
import com.medvault.auth.repository.PatientProfileRepository;
import com.medvault.auth.repository.ProfessionalProfileRepository;
import com.medvault.auth.repository.UserRepository;
import com.medvault.auth.request.PatientProfileRequest;
import com.medvault.auth.request.ProfessionalProfileRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProfileService {

    private final UserRepository userRepository;
    private final PatientProfileRepository patientProfileRepository;
    private final ProfessionalProfileRepository professionalProfileRepository;

    public ProfileService(UserRepository userRepository,
                          PatientProfileRepository patientProfileRepository,
                          ProfessionalProfileRepository professionalProfileRepository) {
        this.userRepository = userRepository;
        this.patientProfileRepository = patientProfileRepository;
        this.professionalProfileRepository = professionalProfileRepository;
    }

    // ==========================
    // ✅ PATIENT
    // ==========================

    public PatientProfile getPatientProfile(String email) {
        return patientProfileRepository
                .findByUser_Email(email)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient profile not found"));
    }

    public PatientProfile upsertPatientProfile(String email, PatientProfileRequest req) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        PatientProfile profile = patientProfileRepository
                .findByUser_Email(email)
                .orElse(new PatientProfile());

        profile.setUser(user);
        profile.setFullName(req.getFullName());
        profile.setPhone(req.getPhone());
        profile.setGender(req.getGender());
        profile.setAddress(req.getAddress());
        profile.setBloodGroup(req.getBloodGroup());
        profile.setDob(req.getDob());

        return patientProfileRepository.save(profile);
    }

    // ==========================
    // ✅ PROFESSIONAL
    // ==========================

    public ProfessionalProfile getProfessionalProfile(String email) {
        return professionalProfileRepository
                .findByUser_Email(email)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Professional profile not found"));
    }

    public ProfessionalProfile upsertProfessionalProfile(String email, ProfessionalProfileRequest req) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ProfessionalProfile profile = professionalProfileRepository
                .findByUser_Email(email)
                .orElse(new ProfessionalProfile());

        profile.setUser(user);
        profile.setDisplayName(req.getDisplayName());
        profile.setPhone(req.getPhone());
        profile.setAddress(req.getAddress());
        profile.setSpecialization(req.getSpecialization());
        profile.setLicenseNumber(req.getLicenseNumber());
        profile.setType(req.getType());

        return professionalProfileRepository.save(profile);
    }
}
