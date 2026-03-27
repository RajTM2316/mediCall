package com.raj.medicall.service;

import com.raj.medicall.dto.AddMedicineRequest;
import com.raj.medicall.entity.Medicine;

public interface MedicineService {
    Medicine registerMedicine(AddMedicineRequest request);
}
