package com.raj.medicall.service;

import com.raj.medicall.dto.AdminRegisterRequest;
import com.raj.medicall.dto.PatientRegisterRequest;
import com.raj.medicall.entity.Role;
import com.raj.medicall.entity.User;
import com.raj.medicall.repository.RoleRepository;
import com.raj.medicall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class AdminServiceIMP implements AdminService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AdminServiceIMP (@Autowired UserRepository userRepository, @Autowired RoleRepository roleRepository){
        this.roleRepository=roleRepository;
        this.userRepository=userRepository;
    }

    @Override
    public Map<String, String> registerAdmin(AdminRegisterRequest request) {
        Map<String, String> response = new HashMap<>();

        if (userRepository.existsByEmail(request.getEmail())) {
            response.put("status", "fail");
            response.put("message", "Email already exists");
            return response;
        }

        Role role = roleRepository
                .findByName("ROLE_ADMIN")
                .orElseThrow(() -> new RuntimeException("Admin role not found"));

        User user = new User();
        user.setName(request.getName());
        user.setPhoneNo(request.getPhoneNo());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);  // assign role

        userRepository.save(user);

        response.put("status", "success");
        response.put("message", "Admin Registered Successfully!!!");

        return response;
    }

}
