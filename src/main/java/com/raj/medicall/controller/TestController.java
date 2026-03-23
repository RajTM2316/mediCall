package com.raj.medicall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test/admin")
    public String adminAccess(){
        return "Admin Access granted";
    }
    @GetMapping("/test/doctor")
    public String doctorAccess(){
        return "Doctor Access granted";
    }
    @GetMapping("/test/patient")
    public String patientAccess(){
        return "Patient Access granted";
    }
    @GetMapping("test/auth")
    public String publicAccess(){
        return "Public endpoint working";
    }
}
