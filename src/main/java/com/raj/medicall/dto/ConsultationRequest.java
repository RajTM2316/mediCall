package com.raj.medicall.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ConsultationRequest {
    private Long PatientId;
    private Long DoctorId;
    private String diagnosis;
    private LocalDate visitDate;
    private LocalTime visitTime;
}
