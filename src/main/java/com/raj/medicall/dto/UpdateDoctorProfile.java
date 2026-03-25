package com.raj.medicall.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UpdateDoctorProfile {
    @NotNull(message = "Doctor ID is required")
    private Long doctorId;

    @NotBlank(message = "Qualification is required")
    @Size(max = 100, message = "Qualification must be under 100 characters")
    private String qualification;

    @NotBlank(message = "Specialization is required")
    @Size(max = 100, message = "Specialization must be under 100 characters")
    private String specialization;

    @Min(value = 0, message = "Experience cannot be negative")
    @Max(value = 60, message = "Experience seems unrealistic")
    private int expYears;

    @NotBlank(message = "Licence number is required")
    @Size(max = 50, message = "Licence number must be under 50 characters")
    private String licenceNumber;

    @NotBlank(message = "Department is required")
    @Size(max = 100, message = "Department must be under 100 characters")
    private String department;

    @Positive(message = "Consultation fee must be greater than 0")
    private double consultationFee;

    @NotNull(message = "Hospital ID is required")
    private Long hospitalId;
}