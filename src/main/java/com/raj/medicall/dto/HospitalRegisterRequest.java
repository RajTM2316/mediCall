package com.raj.medicall.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class HospitalRegisterRequest {
    @NotBlank(message = "Hospital name is required")
    @Size(min = 3, max = 100, message = "Hospital name must be between 3 and 100 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Hospital name must contain only letters")
    private String hospitalName;
    @NotBlank(message = "Hospital address is required")
    @Size(min = 10, max = 500, message = "Address must be between 10 and 500 characters")
    private String hospitalAddress;
}
