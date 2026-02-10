package com.medvault.auth.controller;

import com.medvault.auth.dto.AuthResponse;
import com.medvault.auth.dto.SendOtpRequest;
import com.medvault.auth.dto.VerifyOtpRequest;
import com.medvault.auth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOtp(@RequestBody SendOtpRequest req) {
        authService.sendOtp(req.getEmail(), req.getRole());
        return ResponseEntity.ok("OTP sent to email");
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<AuthResponse> verifyOtp(@RequestBody VerifyOtpRequest req) {
        AuthResponse response = authService.verifyOtp(req.getEmail(), req.getOtp());
        return ResponseEntity.ok(response);
    }
}
