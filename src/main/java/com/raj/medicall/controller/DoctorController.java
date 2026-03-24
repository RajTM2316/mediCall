package com.raj.medicall.controller;

import com.raj.medicall.dto.PrescriptionRequest;
import com.raj.medicall.dto.UpdateDoctorProfile;
import com.raj.medicall.entity.Prescription;
import com.raj.medicall.service.DoctorService;
import com.raj.medicall.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PrescriptionService prescriptionService;

    @PutMapping("/profile")
    public Map<String,String> updateProfile(@RequestBody UpdateDoctorProfile updateDoctorProfile){
        return doctorService.updateDoctorProfile(updateDoctorProfile);
    }

    @PostMapping("/prescription")
    public Prescription createPrescription(@RequestBody PrescriptionRequest request) {
        return prescriptionService.createPrescription(request);
    }

}
