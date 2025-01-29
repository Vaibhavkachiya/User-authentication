package com.example.authsystem.web.dto.ResponseDto;

public class RegisterResponse {

    private String message;  // Success or failure message
    private String username; // The registered username (optional)
    private boolean success; // Indicates whether the registration was successful

    // Constructors
    public RegisterResponse() {
    }

    public RegisterResponse(String message, String username, boolean success) {
        this.message = message;
        this.username = username;
        this.success = success;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "RegisterResponse{" +
                "message='" + message + '\'' +
                ", username='" + username + '\'' +
                ", success=" + success +
                '}';
    }
}
