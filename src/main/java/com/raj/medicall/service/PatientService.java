package com.raj.medicall.service;

import com.raj.medicall.dto.UpdatePatientProfile;
import com.raj.medicall.dto.UserRegisterRequest;

import java.util.Map;

public interface PatientService {
    Map<String,String> registerPatient(UserRegisterRequest request);
    Map<String,String> updateProfile(UpdatePatientProfile request);
}
