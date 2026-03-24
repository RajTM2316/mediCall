package com.raj.medicall.service;

import com.raj.medicall.dto.AddMedicineRequest;
import com.raj.medicall.dto.PatientRegisterRequest;
import com.raj.medicall.entity.Medicine;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface MedicineService {
    Medicine registerMedicine(AddMedicineRequest request);
}
