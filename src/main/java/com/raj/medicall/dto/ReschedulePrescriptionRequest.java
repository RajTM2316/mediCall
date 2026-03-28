package com.raj.medicall.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReschedulePrescriptionRequest {
    @NotNull(message = "Medicine ID is required")
    private Long prescriptionId;
    @NotNull(message = "Time to take medicine is required")
    private LocalTime timeToTake;
    @NotNull(message = "Start date is required")
    private LocalDate startDate;
    @NotNull(message = "End date is required")
    private LocalDate endDate;
    @AssertTrue(message = "End date must be after or equal to start date")
    public boolean isValidDateRange() {
        if (startDate == null || endDate == null) return true;
        return !endDate.isBefore(startDate);
    }
}
