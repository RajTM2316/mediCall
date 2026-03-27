package com.raj.medicall.service;

import com.raj.medicall.dto.HospitalRegisterRequest;

import java.util.Map;

public interface HospitalService {
    Map<String,String> registerHospital(HospitalRegisterRequest request);
}
