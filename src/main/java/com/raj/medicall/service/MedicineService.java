package com.raj.medicall.service;

import com.raj.medicall.dto.AddMedicineRequest;
import com.raj.medicall.entity.Medicine;

import java.util.List;

public interface MedicineService {
    Medicine registerMedicine(AddMedicineRequest request);
    List<Medicine> getAll();
    String remove(Long id);
}
