package com.raj.medicall.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ConsultationRequest {
    @NotNull(message = "Patient ID is required")
    private Long patientId;
    @NotNull(message = "Doctor ID is required")
    private Long doctorId;
    @NotBlank(message = "Diagnosis cannot be empty")
    private String diagnosis;
    @NotNull(message = "Visit date is required")
    private LocalDate visitDate;
    @NotNull(message = "Visit time is required")
    private LocalTime visitTime;
}
