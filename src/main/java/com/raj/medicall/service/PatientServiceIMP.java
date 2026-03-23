package com.raj.medicall.service;

import com.raj.medicall.dto.PatientRegisterRequest;
import com.raj.medicall.dto.UpdatePatientProfile;
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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
    public Map<String, String> registerPatient(PatientRegisterRequest request) {
        Map<String, String> response = new HashMap<>();
        if(userRepository.existsByEmail(request.getEmail())){
            response.put("status", "fail");
            response.put("message", "Email already exists");
            return response;
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

        response.put("status", "success");
        response.put("message", "Patient Registered Successfully!!!");
        return response;
    }

    @Override
    public Map<String, String> updateProfile(UpdatePatientProfile request) {
        Map<String,String> response = new HashMap<>();
        Optional<Patient> optionalPatient = patientRepository.findById(request.getPatientId());
        if (optionalPatient.isEmpty()) {
            response.put("status", "error");
            response.put("message", "Patient not found");
            return response;
        }
        Patient patient = optionalPatient.get();
        patient.setAge(request.getAge());
        patient.setGender(request.getGender());
        patient.setEmergencyContact(request.getEmergencyContact());
        patient.setBloodGroup(request.getBloodGroup());
        patient.setHeight(request.getHeight());
        patient.setWeight(request.getWeight());
        patientRepository.save(patient);
        response.put("status", "success");
        response.put("message", "Profile updated successfully");
        return response;
    }
}
