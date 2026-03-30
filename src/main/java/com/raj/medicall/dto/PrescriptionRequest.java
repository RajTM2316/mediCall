package com.raj.medicall.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class PrescriptionRequest {
    @NotNull(message = "Consultation ID is required")
    private Long consultationId;
    @NotNull(message = "Medicine ID is required")
    private Long medicineId;
    @NotBlank(message = "Dosage is required")
    @Size(max = 100, message = "Dosage must be under 100 characters")
    private String dosage;
    @NotBlank(message = "Frequency is required")
    @Size(max = 50, message = "Frequency must be under 50 characters")
    private String frequency;
    @NotNull(message = "Time to take medicine is required")
    private LocalTime timeToTake;
    @NotNull(message = "Start date is required")
    private LocalDate startDate;
    @NotNull(message = "End date is required")
    private LocalDate endDate;
    @Size(max = 300, message = "Notes must be under 300 characters")
    private String notes;

    /*
It is a Bean Validation annotation from jakarta.validation. It tells Spring:
"Run this method when validating — if it returns false,
throw a validation error with this message."
*/
    @AssertTrue(message = "End date must be after or equal to start date")
    public boolean isValidDateRange() {
        if (startDate == null || endDate == null) return true;
        return !endDate.isBefore(startDate);
    }
}