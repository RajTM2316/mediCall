package com.raj.medicall.service;

import com.raj.medicall.dto.PatientRegisterRequest;
import com.raj.medicall.entity.Patient;
import com.raj.medicall.entity.Role;
import com.raj.medicall.repository.PatientRepository;
import com.raj.medicall.repository.RoleRepository;
import com.raj.medicall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PatientServiceIMP implements PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public String registerPatient(PatientRegisterRequest request) {
        if(userRepository.existsByEmail(request.getEmail())){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Email already exists"
            );
        }
        Role role = roleRepository
                .findByName("ROLE_PATIENT")
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Patient patient = new Patient();
        patient.setName(request.getName());
        patient.setEmail(request.getEmail());
        patient.setPassword(passwordEncoder.encode(request.getPassword()));
        patient.setPhoneNo(request.getPhoneNo());
        patient.setRole(role);
        patientRepository.save(patient);
        return "Patient Registered Successfully!!!";
    }
}
