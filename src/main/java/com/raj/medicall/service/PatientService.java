package com.raj.medicall.service;

import com.raj.medicall.dto.PatientRegisterRequest;
import com.raj.medicall.dto.UpdatePatientProfile;

import java.util.Map;

public interface PatientService {
    Map<String,String> registerPatient(PatientRegisterRequest request);
    Map<String,String> updateProfile(UpdatePatientProfile request);
}
