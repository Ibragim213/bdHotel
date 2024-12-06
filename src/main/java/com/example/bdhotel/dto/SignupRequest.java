package com.example.bdhotel.dto;

import lombok.Data;


    @Data
    public class SignupRequest {
        private String fullName;
        private String birthDate;
        private String phoneNumber;
        private String email;
        private int passport;
        private String password;



    }