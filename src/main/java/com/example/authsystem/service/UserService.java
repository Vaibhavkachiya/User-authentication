package com.example.authsystem.service;

import com.example.authsystem.entity.User;
import com.example.authsystem.web.dto.RequestDto.RegisterRequest;
import com.example.authsystem.web.dto.ResponseDto.LoginResponse;

import java.util.List;

public interface UserService {
    void registerUser(RegisterRequest request);
    LoginResponse login(String username, String password);
    List<User> getAllUsers(); // Return type changed to List<User> for clarity
    boolean deleteUser(Long id); // Return type changed to boolean for success/failure indication
}
