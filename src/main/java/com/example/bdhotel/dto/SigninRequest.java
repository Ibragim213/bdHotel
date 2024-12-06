package com.example.bdhotel.dto;

public class SigninRequest {
    private String email;
    private String password;

    // Геттер для email
    public String getEmail() {
        return email;
    }

    // Геттер для password
    public String getPassword() {
        return password;
    }

    // Сеттеры (если нужны)
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
