package com.raj.medicall.dto;

import lombok.Data;

@Data
public class DoctorRegisterRequest {
    private String name;
    private String email;
    private String phoneNo;
    private String password;
}
