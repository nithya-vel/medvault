package com.medvault.auth.controller;

import com.medvault.auth.entity.PatientProfile;
import com.medvault.auth.request.PatientProfileRequest;
import com.medvault.auth.service.ProfileService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")
public class PatientProfileController {

    private final ProfileService profileService;

    public PatientProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/profile")
    public PatientProfile get(Authentication auth) {
        return profileService.getPatientProfile(auth.getName());
    }

    @PostMapping("/profile")
    public PatientProfile upsert(Authentication auth,
                                 @RequestBody PatientProfileRequest req) {
        return profileService.upsertPatientProfile(auth.getName(), req);
    }
}
