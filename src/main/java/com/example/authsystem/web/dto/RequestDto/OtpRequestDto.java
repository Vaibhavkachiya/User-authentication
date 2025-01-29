package com.example.authsystem.web.dto.RequestDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OtpRequestDto {
    private String phoneNumber;
    private String otpCode;

}