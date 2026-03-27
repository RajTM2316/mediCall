package com.raj.medicall.service;

import com.raj.medicall.dto.PrescriptionRequest;
import com.raj.medicall.entity.Prescription;

import java.util.List;

public interface PrescriptionService {
    public Prescription createPrescription(PrescriptionRequest request);
    public Prescription getById(Long id);
    public List<Prescription> getAll();
}
