package com.raj.medicall.controller;

import com.raj.medicall.dto.AdminRegisterRequest;
import com.raj.medicall.dto.PatientRegisterRequest;
import com.raj.medicall.service.AdminService;
import com.raj.medicall.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class RegisterController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/register/patients")
    public Map<String, String> registerPatient(@RequestBody PatientRegisterRequest request){
        return patientService.registerPatient(request);
    }

    @PostMapping("/register/admins")
    public Map<String, String> registerAdmin(@RequestBody AdminRegisterRequest request){
        return adminService.registerAdmin(request);
    }
}