package com.medvault.auth.repository;

import com.medvault.auth.entity.PatientProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientProfileRepository extends JpaRepository<PatientProfile, Long> {

    Optional<PatientProfile> findByUser_Email(String email);

    boolean existsByUser_Email(String email);
}
