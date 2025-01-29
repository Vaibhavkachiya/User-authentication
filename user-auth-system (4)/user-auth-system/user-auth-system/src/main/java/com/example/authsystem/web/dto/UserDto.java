package com.example.authsystem.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
}
