package com.raj.medicall.service;

import com.raj.medicall.dto.AddMedicineRequest;
import com.raj.medicall.entity.Medicine;
import com.raj.medicall.exception.ResourceNotFoundException;
import com.raj.medicall.repository.MedicineRepository;
import com.raj.medicall.repository.PrescriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;

@Service
public class MedicineServiceIMP implements MedicineService{

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    @Transactional
    public Medicine registerMedicine(AddMedicineRequest request) {
        Medicine medicine = new Medicine();
        medicine.setName(request.getName());
        medicine.setType(request.getType());
        medicine.setStrength(request.getStrength());
        medicine.setManufacturer(request.getManufacturer());
        medicine.setDescription(request.getDescription());

        return medicineRepository.save(medicine);
    }

    @Override
    public List<Medicine> getAll() {
        return medicineRepository.findAll();
    }

    @Transactional
    @Override
    public String remove(Long id) {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Medicine not found"));

        // 1. Delete all prescriptions using this medicine
        prescriptionRepository.deleteByMedicine(medicine);

        // 2. Now delete medicine
        medicineRepository.delete(medicine);
        return "Medicine Removed From The Store";
    }
}
