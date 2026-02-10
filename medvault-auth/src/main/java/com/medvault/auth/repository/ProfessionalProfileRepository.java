package com.medvault.auth.repository;

import com.medvault.auth.entity.ProfessionalProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessionalProfileRepository
        extends JpaRepository<ProfessionalProfile, Long> {

    Optional<ProfessionalProfile> findByUser_Email(String email);
}
