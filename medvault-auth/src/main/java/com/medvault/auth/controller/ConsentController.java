package com.medvault.auth.controller;

import com.medvault.auth.dto.ConsentActionRequest;
import com.medvault.auth.dto.ConsentRequest;
import com.medvault.auth.entity.PatientConsent;
import com.medvault.auth.service.ConsentService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/consent")
public class ConsentController {

    private final ConsentService consentService;

    public ConsentController(ConsentService consentService) {
        this.consentService = consentService;
    }

    @PostMapping("/request")
    public PatientConsent request(Authentication auth, @RequestBody ConsentRequest req) {

        if (auth == null || auth.getName() == null || auth.getName().isBlank()) {
            throw new RuntimeException("Unauthorized: token missing/invalid (auth is null)");
        }

        if (req == null || req.getProfessionalEmail() == null || req.getProfessionalEmail().isBlank()) {
            throw new RuntimeException("professionalEmail is required");
        }

        return consentService.requestConsent(auth.getName(), req.getProfessionalEmail());
    }

    @PostMapping("/grant")
    public PatientConsent grant(Authentication auth, @RequestBody ConsentActionRequest req) {

        if (auth == null || auth.getName() == null || auth.getName().isBlank()) {
            throw new RuntimeException("Unauthorized: token missing/invalid");
        }

        if (req == null || req.getPatientEmail() == null || req.getPatientEmail().isBlank()) {
            throw new RuntimeException("patientEmail is required");
        }

        return consentService.grantConsent(auth.getName(), req.getPatientEmail());
    }

    @PostMapping("/revoke")
    public PatientConsent revoke(Authentication auth, @RequestBody ConsentActionRequest req) {

        if (auth == null || auth.getName() == null || auth.getName().isBlank()) {
            throw new RuntimeException("Unauthorized: token missing/invalid");
        }

        if (req == null || req.getPatientEmail() == null || req.getPatientEmail().isBlank()) {
            throw new RuntimeException("patientEmail is required");
        }

        return consentService.revokeConsent(auth.getName(), req.getPatientEmail());
    }
}
