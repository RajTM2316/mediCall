package com.raj.medicall.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AddMedicineRequest {
    @NotBlank (message = "Medicine name is required")
    private String name;

    @NotBlank(message = "Medicine type is required")
    private String type;

    @NotBlank(message = "Medicine Manufacturer is required")
    private String manufacturer;

    @NotBlank(message = "Medicine strength is required")
    private String strength;
    @Lob
    private String description;
}
