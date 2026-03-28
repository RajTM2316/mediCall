package com.raj.medicall.controller;

import com.raj.medicall.entity.Hospital;
import com.raj.medicall.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

        @GetMapping("/hospitals")
        public List<Hospital> getAllHospitals(){
        return hospitalService.getAllHospital();
        }
}
