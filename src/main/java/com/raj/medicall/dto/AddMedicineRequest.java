package com.raj.medicall.dto;

import jakarta.persistence.Lob;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AddMedicineRequest {
    private String name;

    private String type;

    private String manufacturer;

    private String strength;
    @Lob
    private String description;
}
