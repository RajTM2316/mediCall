package com.raj.medicall.controller;

import com.raj.medicall.dto.UpdateDoctorProfile;
import com.raj.medicall.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PutMapping("/profile")
    public Map<String,String> updateProfile(@RequestBody UpdateDoctorProfile updateDoctorProfile){
        return doctorService.updateDoctorProfile(updateDoctorProfile);
    }
}
