package com.example.authsystem.repository;

import com.example.authsystem.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp, Long> {
    Optional<Otp> findByPhoneNumberAndOtpCode(String phoneNumber, String otpCode);
}
