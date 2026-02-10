package com.medvault.auth.repository;

import com.medvault.auth.entity.PatientConsent;
import com.medvault.auth.entity.ConsentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PatientConsentRepository extends JpaRepository<PatientConsent, Long> {

    Optional<PatientConsent> findByPatient_EmailAndProfessional_Email(String patientEmail, String professionalEmail);

    List<PatientConsent> findByPatient_Email(String patientEmail);

    List<PatientConsent> findByProfessional_EmailAndStatus(String professionalEmail, ConsentStatus status);
}
