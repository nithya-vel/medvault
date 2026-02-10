package com.medvault.auth.dto;

import com.medvault.auth.entity.Role;

public class SendOtpRequest {
    private String email;
    private Role role = Role.PATIENT;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}
