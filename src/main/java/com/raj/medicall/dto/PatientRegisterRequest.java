package com.raj.medicall.dto;

import lombok.Data;

@Data
public class PatientRegisterRequest {
    private String name;
    private String email;
    private String phoneNo;
    private String password;
}
