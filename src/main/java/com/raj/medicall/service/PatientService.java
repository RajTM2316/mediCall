package com.raj.medicall.service;

import com.raj.medicall.dto.PatientRegisterRequest;

import java.util.Map;

public interface PatientService {
    Map<String,String> registerPatient(PatientRegisterRequest request);
}
