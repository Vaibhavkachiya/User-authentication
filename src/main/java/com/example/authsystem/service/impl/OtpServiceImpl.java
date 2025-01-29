package com.example.authsystem.service.impl;

import com.example.authsystem.entity.Otp;
import com.example.authsystem.repository.OtpRepository;
import com.example.authsystem.service.OtpService;
import com.example.authsystem.web.dto.RequestDto.OtpRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class OtpServiceImpl implements OtpService {

    private final OtpRepository otpRepository;

    @Autowired
    public OtpServiceImpl(OtpRepository otpRepository) {
        this.otpRepository = otpRepository;
    }

    @Override
    public void sendOtp(String phoneNumber) {
        String generatedOtp = String.valueOf(new Random().nextInt(900000) + 100000);
        Otp otp = new Otp();
        otp.setOtpCode(generatedOtp);
        otp.setPhoneNumber(phoneNumber);
        otpRepository.save(otp);
    }

	@Override
	public boolean verifyOtp(OtpRequestDto otpRequestDto) {
		// TODO Auto-generated method stub
		return false;
	}

}

   
