package com.medvault.auth.repository;

import com.medvault.auth.entity.OtpVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<OtpVerification, Long> {

    Optional<OtpVerification> findByEmail(String email);
    
    @Modifying
    @Transactional
    @Query("delete from OtpVerification o where o.email = :email")
    void deleteByEmail(String email);
}
