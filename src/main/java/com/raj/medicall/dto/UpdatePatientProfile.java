package com.raj.medicall.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class UpdatePatientProfile {

    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 120, message = "Age seems unrealistic")
    private int age;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")
    private String gender;

    @Positive(message = "Height must be greater than 0")
    @Max(value = 300, message = "Height seems unrealistic")
    private double height;

    @Positive(message = "Weight must be greater than 0")
    @Max(value = 500, message = "Weight seems unrealistic")
    private double weight;

    @NotBlank(message = "Blood group is required")
    @Pattern(
            regexp = "^(A|B|AB|O)[+-]$",
            message = "Invalid blood group (e.g., A+, O-)"
    )
    private String bloodGroup;

    @NotBlank(message = "Emergency contact is required")
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Emergency contact must be a valid 10-digit number"
    )
    private String emergencyContact;

    private List<String> allergies;
}
