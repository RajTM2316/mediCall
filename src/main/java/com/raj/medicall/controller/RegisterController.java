package com.raj.medicall.controller;

import com.raj.medicall.dto.*;
import com.raj.medicall.entity.Medicine;
import com.raj.medicall.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private MedicineService medicineService;

    @PostMapping("/register/patients")
    public Map<String, String> registerPatient(@Valid @RequestBody UserRegisterRequest request){
        return patientService.registerPatient(request);
    }

    @PostMapping("/register/admins")
    public Map<String, String> registerAdmin(@Valid @RequestBody UserRegisterRequest request){
        return adminService.registerAdmin(request);
    }

    @PostMapping("/register/doctors")
    public Map<String,String> registerDoctor(@Valid @RequestBody UserRegisterRequest request){
        return doctorService.registerDoctor(request);
    }

    @PostMapping("/register/hospitals")
    public Map<String,String> registerHospital(@Valid @RequestBody HospitalRegisterRequest request){
        return hospitalService.registerHospital(request);
    }

    @PostMapping("/register/medicines")
    public ResponseEntity<Medicine> registerMedicine(@Valid @RequestBody AddMedicineRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(medicineService.registerMedicine(request));
    }

}