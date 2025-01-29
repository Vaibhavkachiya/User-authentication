package com.example.authsystem.web.dto.RequestDto;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

	 
	    private String username;
	    private String email;
	    private String password;
	    private String confirmPassword;

	    
	 
}

