package com.raj.medicall.dto;

import lombok.Data;

@Data
public class UpdatePatientProfile {
    private Long patientId;
    private int age;
    private String gender;
    private double height;
    private double weight;
    private String bloodGroup;
    private String emergencyContact;
}
