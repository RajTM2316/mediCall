package com.raj.medicall.service;

import com.raj.medicall.dto.DoctorRegisterRequest;
import com.raj.medicall.entity.Doctor;
import com.raj.medicall.entity.Role;
import com.raj.medicall.repository.DoctorRepository;
import com.raj.medicall.repository.RoleRepository;
import com.raj.medicall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DoctorServiceIMP implements DoctorService{
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Map<String, String> registerDoctor(DoctorRegisterRequest request) {
        Map<String,String> response = new HashMap<>();
        if(userRepository.existsByEmail(request.getEmail())){
            response.put("status", "fail");
            response.put("message", "Email already exists");
            return response;
        }

        Role role = roleRepository
                .findByName("ROLE_DOCTOR")
                .orElseThrow(() -> new RuntimeException("Role not found"));
        Doctor doctor=new Doctor();
        doctor.setName(request.getName());
        doctor.setEmail(request.getEmail());
        doctor.setPhoneNo(request.getPhoneNo());
        doctor.setRole(role);
        doctor.setPassword(passwordEncoder.encode(request.getPassword()));
        doctorRepository.save(doctor);
        response.put("status", "success");
        response.put("message", "Doctor Registered Successfully!!!");
        return response;
    }
}
