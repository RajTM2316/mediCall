package com.raj.medicall.controller;

import com.raj.medicall.dto.AdminRegisterRequest;
import com.raj.medicall.dto.DoctorRegisterRequest;
import com.raj.medicall.dto.HospitalRegisterRequest;
import com.raj.medicall.dto.PatientRegisterRequest;
import com.raj.medicall.service.AdminService;
import com.raj.medicall.service.DoctorService;
import com.raj.medicall.service.HospitalService;
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

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private HospitalService hospitalService;

    @PostMapping("/register/patients")
    public Map<String, String> registerPatient(@RequestBody PatientRegisterRequest request){
        return patientService.registerPatient(request);
    }

    @PostMapping("/register/admins")
    public Map<String, String> registerAdmin(@RequestBody AdminRegisterRequest request){
        return adminService.registerAdmin(request);
    }

    @PostMapping("/register/doctors")
    public Map<String,String> registerDoctor(@RequestBody DoctorRegisterRequest request){
        return doctorService.registerDoctor(request);
    }

    @PostMapping("/register/hospitals")
    public Map<String,String> registerDoctor(@RequestBody HospitalRegisterRequest request){
        return hospitalService.registerHospital(request);
    }
}