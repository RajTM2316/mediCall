package com.raj.medicall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/admin/test")
    public String adminAccess(){
        return "Admin Access granted";
    }
    @GetMapping("/doctor/test")
    public String doctorAccess(){
        return "Doctor Access granted";
    }
    @GetMapping("/patient/test")
    public String patientAccess(){
        return "Patient Access granted";
    }
    @GetMapping("/auth/test")
    public String publicAccess(){
        return "Public endpoint working";
    }
}
