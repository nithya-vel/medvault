package com.medvault.auth.security;

import com.medvault.auth.entity.User;
import com.medvault.auth.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;

    public CustomUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        // IMPORTANT: ROLE_ prefix
        String role = "ROLE_" + user.getRole().name();

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                "", // no password (OTP based)
                List.of(new SimpleGrantedAuthority(role))
        );
    }
}
