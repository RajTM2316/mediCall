package com.raj.medicall.service;

import com.raj.medicall.dto.PrescriptionRequest;
import com.raj.medicall.entity.Consultation;
import com.raj.medicall.entity.Medicine;
import com.raj.medicall.entity.Prescription;
import com.raj.medicall.exception.ResourceNotFoundException;
import com.raj.medicall.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionServiceIMP implements PrescriptionService{
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private ConsultationRepository consultationRepository;
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    @Transactional
    public Prescription createPrescription(PrescriptionRequest request) {
        Consultation consultation = consultationRepository.findById(request.getConsultationId())
                .orElseThrow(()-> new ResourceNotFoundException("Consultation not found"));

        Medicine medicine = medicineRepository.findById(request.getMedicineId())
                .orElseThrow(()-> new ResourceNotFoundException("Medicine not found"));

        Prescription prescription = new Prescription();

        prescription.setConsultation(consultation);
        prescription.setMedicine(medicine);
        prescription.setDosage(request.getDosage());
        prescription.setFrequency(request.getFrequency());
        prescription.setStartDate(request.getStartDate());
        prescription.setEndDate(request.getEndDate());
        prescription.setTimeToTake(request.getTimeToTake());
        prescription.setNotes(request.getNotes());
        return prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription getById(Long id) {
        return prescriptionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Prescription not Found"));
    }

    @Override
    public List<Prescription> getAll() {
        return prescriptionRepository.findAll();
    }




}
