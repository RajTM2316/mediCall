package com.raj.medicall.service;

import com.raj.medicall.dto.AdminRegisterRequest;
import com.raj.medicall.dto.PatientRegisterRequest;

import java.util.Map;

public interface AdminService {
    Map<String,String> registerAdmin(AdminRegisterRequest request);
}
