package com.raj.medicall.controller;

import com.raj.medicall.dto.UpdatePatientProfile;
import com.raj.medicall.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PutMapping("/profile")
    public Map<String,String> updateProfile(@RequestBody UpdatePatientProfile updatePatientProfile){
        return patientService.updateProfile(updatePatientProfile);
    }
}
