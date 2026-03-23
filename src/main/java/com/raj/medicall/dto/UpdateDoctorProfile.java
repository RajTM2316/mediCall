package com.raj.medicall.dto;

import lombok.Data;

@Data
public class UpdateDoctorProfile {
    private Long doctorId;
    private String qualification;
    private String specialization;
    private int expYears;
    private String licenceNumber;
    private String department;
    private double consultationFee;
    private Long hospitalId;
}