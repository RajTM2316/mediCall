package com.raj.medicall.service;

import com.raj.medicall.dto.UpdateDoctorProfile;
import com.raj.medicall.dto.UserRegisterRequest;

import java.util.Map;

public interface DoctorService {
    Map<String,String> registerDoctor(UserRegisterRequest request);
    public Map<String, String> updateDoctorProfile(UpdateDoctorProfile request);
}
