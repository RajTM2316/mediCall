package com.raj.medicall.service;

import com.raj.medicall.dto.HospitalRegisterRequest;
import com.raj.medicall.entity.Hospital;

import java.util.List;
import java.util.Map;

public interface HospitalService {
    Map<String,String> registerHospital(HospitalRegisterRequest request);
    public List<Hospital> getAllHospital();
}
