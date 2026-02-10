package com.medvault.auth.controller;

import com.medvault.auth.entity.ProfessionalProfile;
import com.medvault.auth.request.ProfessionalProfileRequest;
import com.medvault.auth.service.ProfileService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/professional")
public class ProfessionalProfileController {

    private final ProfileService profileService;

    public ProfessionalProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/profile")
    public ProfessionalProfile get(Authentication auth) {
        return profileService.getProfessionalProfile(auth.getName());
    }

    @PostMapping("/profile")
    public ProfessionalProfile upsert(Authentication auth,
                                      @RequestBody ProfessionalProfileRequest req) {
        return profileService.upsertProfessionalProfile(auth.getName(), req);
    }
}
