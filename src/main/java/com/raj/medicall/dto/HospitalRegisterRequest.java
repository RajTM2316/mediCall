package com.raj.medicall.dto;

import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class HospitalRegisterRequest {
    private String hospitalName;
    @Lob
    private String hospitalAddress;
}
