package com.raj.medicall.service;

import com.raj.medicall.dto.AddMedicineRequest;
import com.raj.medicall.entity.Medicine;
import com.raj.medicall.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
@Service
public class MedicineServiceIMP implements MedicineService{

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public Medicine registerMedicine(AddMedicineRequest request) {
        Medicine medicine = new Medicine();
        medicine.setName(request.getName());
        medicine.setType(request.getType());
        medicine.setStrength(request.getStrength());
        medicine.setManufacturer(request.getManufacturer());
        medicine.setDescription(request.getDescription());

        return medicineRepository.save(medicine);
    }
}
