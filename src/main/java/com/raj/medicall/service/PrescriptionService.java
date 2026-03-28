package com.raj.medicall.service;

import com.raj.medicall.dto.PrescriptionRequest;
import com.raj.medicall.entity.Prescription;

import java.security.PublicKey;
import java.util.List;

public interface PrescriptionService {
    public Prescription createPrescription(PrescriptionRequest request);
    public Prescription getById(Long id);
    public List<Prescription> getAll();
    public List<Prescription> getByConsultationId(Long consultationId);
    public List<Prescription> getByPatientId(Long patientId);
    public List<Prescription> getByDoctorId(Long doctorId);
}
