package com.raj.medicall.service;

import com.raj.medicall.dto.UpdateDoctorProfile;
import com.raj.medicall.dto.UserRegisterRequest;
import com.raj.medicall.entity.Doctor;
import com.raj.medicall.entity.Hospital;
import com.raj.medicall.entity.Role;
import com.raj.medicall.exception.ResourceNotFoundException;
import com.raj.medicall.repository.DoctorRepository;
import com.raj.medicall.repository.HospitalRepository;
import com.raj.medicall.repository.RoleRepository;
import com.raj.medicall.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    @Transactional
    public Map<String, String> registerDoctor(UserRegisterRequest request) {
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

    @Override
    @Transactional
    public Map<String, String> updateDoctorProfile(UpdateDoctorProfile request) {
        Map<String,String> response=new HashMap<>();

        // Get logged-in doctor
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        // Fetch doctor using email
        Doctor doctor = doctorRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));

        doctor.setQualification(request.getQualification());
        doctor.setSpecialization(request.getSpecialization());
        doctor.setExpYears(request.getExpYears());
        doctor.setLicenceNumber(request.getLicenceNumber());
        doctor.setDepartment(request.getDepartment());
        doctor.setConsultationFee(request.getConsultationFee());

        if (request.getHospitalId() != null) {
            Optional<Hospital> optionalHospital = hospitalRepository.findById(request.getHospitalId());
            if (optionalHospital.isEmpty()) {
                response.put("status", "error");
                response.put("message", "Hospital not found");
                return response;
            }
            doctor.setHospital(optionalHospital.get());
        }

        doctorRepository.save(doctor);

        response.put("status", "success");
        response.put("message", "Doctor profile updated successfully");

        return  response;
    }
}
