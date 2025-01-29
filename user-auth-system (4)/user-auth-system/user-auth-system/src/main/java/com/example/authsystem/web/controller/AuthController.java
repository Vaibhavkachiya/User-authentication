package com.example.authsystem.web.controller;

import com.example.authsystem.config.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;
    private final Set<String> blacklistedTokens = new HashSet<>();
    private final Map<String, String> resetTokens = new HashMap<>();

    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok("User registered successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String token = jwtTokenProvider.generateToken(loginRequest.username);
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {
        String actualToken = token.replace("Bearer ", "");
        if (blacklistedTokens.contains(actualToken)) {
            return ResponseEntity.ok("Token already logged out.");
        }
        blacklistedTokens.add(actualToken);
        return ResponseEntity.ok("User logged out successfully.");
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        String resetToken = UUID.randomUUID().toString();
        resetTokens.put(email, resetToken);
        return ResponseEntity.ok("Reset token generated successfully. Use this token: " + resetToken);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String email,
                                                @RequestParam String resetToken,
                                                @RequestParam String newPassword) {
        String validToken = resetTokens.get(email);
        if (validToken != null && validToken.equals(resetToken)) {
            resetTokens.remove(email);
            return ResponseEntity.ok("Password reset successful.");
        }
        return ResponseEntity.badRequest().body("Invalid token or email.");
    }

    static class RegisterRequest {
        public String username;
        public String email;
        public String password;
        public String confirmPassword;
    }

    static class LoginRequest {
        public String username;
        public String password;
    }

    static class LoginResponse {
        public String token;

        public LoginResponse(String token) {
            this.token = token;
        }
    }
}