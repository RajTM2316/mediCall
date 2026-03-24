package com.raj.medicall.service;

import com.raj.medicall.dto.PrescriptionRequest;
import com.raj.medicall.entity.Prescription;

public interface PrescriptionService {
    public Prescription createPrescription(PrescriptionRequest request);
}
