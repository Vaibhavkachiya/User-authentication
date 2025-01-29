package com.example.authsystem.config;

import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfig {

    @Value("${twilio.account-sid}")
    private String accountSid;

    @Value("${twilio.auth-token}")
    private String authToken;

    @PostConstruct
    public void initTwilio() {
        if (accountSid == null || authToken == null) {
            throw new IllegalArgumentException("Twilio credentials are missing!");
        }
        Twilio.init(accountSid, authToken);
    }
}

