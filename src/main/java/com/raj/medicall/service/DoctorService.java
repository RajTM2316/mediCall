package com.raj.medicall.service;

import com.raj.medicall.dto.DoctorRegisterRequest;
import com.raj.medicall.dto.PatientRegisterRequest;

import java.util.Map;

public interface DoctorService {
    Map<String,String> registerDoctor(DoctorRegisterRequest request);
}
