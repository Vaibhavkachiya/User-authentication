package com.example.authsystem.web.controller;

import com.example.authsystem.service.OtpService;
import com.example.authsystem.web.dto.RequestDto.OtpRequestDto;
import com.example.authsystem.web.dto.ResponseDto.OtpResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/otp")
public class OtpController {

    private final OtpService otpService;

    public OtpController(OtpService otpService) {
        this.otpService = otpService;
    }

    @PostMapping("/send")
    public void sendOtp(@RequestParam String phoneNumber) {
        otpService.sendOtp(phoneNumber);
    }

    @PostMapping("/verify")
    public OtpResponseDto verifyOtp(@RequestBody OtpRequestDto otpRequestDto) {
        boolean isValid = otpService.verifyOtp(otpRequestDto);
        return new OtpResponseDto(isValid);
    }
}
