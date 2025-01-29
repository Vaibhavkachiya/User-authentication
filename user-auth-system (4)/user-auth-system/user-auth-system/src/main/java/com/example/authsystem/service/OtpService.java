package com.example.authsystem.service;

import com.example.authsystem.web.dto.RequestDto.OtpRequestDto;

public interface OtpService {
    void sendOtp(String phoneNumber);
    boolean verifyOtp(OtpRequestDto otpRequestDto);
}
