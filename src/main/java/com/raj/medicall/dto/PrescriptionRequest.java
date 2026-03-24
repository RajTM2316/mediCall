package com.raj.medicall.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class PrescriptionRequest {
    private Long consultationId;
    private Long medicineId;
    private String dosage;
    private String frequency;
    private LocalTime timeToTake;
    private LocalDate startDate;
    private LocalDate endDate;
    private String notes;
}