package com.raj.medicall.service;

import com.raj.medicall.dto.PatientRegisterRequest;

public interface PatientService {
    String registerPatient(PatientRegisterRequest request);
}
