package com.medvault.auth.service;

import com.medvault.auth.dto.AuthResponse;
import org.springframework.transaction.annotation.Transactional;
import com.medvault.auth.entity.OtpVerification;
import com.medvault.auth.entity.Role;
import com.medvault.auth.entity.User;
import com.medvault.auth.repository.OtpRepository;
import com.medvault.auth.repository.UserRepository;
import com.medvault.auth.security.JwtUtil;
import com.medvault.auth.util.OtpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final OtpRepository otpRepository;
    private final EmailService emailService;
    private final JwtUtil jwtUtil;

    @Value("${otp.expiryMinutes:5}")
    private int otpExpiryMinutes;

    public AuthService(UserRepository userRepository,
                       OtpRepository otpRepository,
                       EmailService emailService,
                       JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.otpRepository = otpRepository;
        this.emailService = emailService;
        this.jwtUtil = jwtUtil;
    }

    // used for BOTH register and login
    public void sendOtp(String email, Role role) {
        // Create user if not exists
        User user = userRepository.findByEmail(email).orElseGet(() -> {
            User u = new User();
            u.setEmail(email);
            u.setRole(role);
            u.setVerified(false);
            u.setCreatedAt(LocalDateTime.now());
            return userRepository.save(u);
        });

        // If user exists and role is different, keep existing role (or you can enforce)
        if (user.getRole() == null) {
            user.setRole(role);
            userRepository.save(user);
        }

        // Generate OTP and upsert OTP row
        String otp = OtpUtil.generate6DigitOtp();

        OtpVerification otpEntity = otpRepository.findByEmail(email).orElseGet(OtpVerification::new);
        otpEntity.setEmail(email);
        otpEntity.setOtp(otp);
        otpEntity.setExpiryTime(LocalDateTime.now().plusMinutes(otpExpiryMinutes));
        otpRepository.save(otpEntity);

        // Send email
        emailService.sendOtp(email, otp);
    }
    
    @Transactional
    public AuthResponse verifyOtp(String email, String otp) {
        OtpVerification saved = otpRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("OTP not found. Please request OTP again."));

        if (saved.getExpiryTime().isBefore(LocalDateTime.now())) {
            otpRepository.deleteByEmail(email);
            throw new RuntimeException("OTP expired. Please request OTP again.");
        }

        if (!saved.getOtp().equals(otp)) {
            throw new RuntimeException("Invalid OTP.");
        }

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found."));

        user.setVerified(true);
        userRepository.save(user);

        otpRepository.deleteByEmail(email);

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());
        return new AuthResponse(token, user.getEmail(), user.getRole());
    }
}
