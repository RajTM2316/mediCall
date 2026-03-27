package com.raj.medicall.service;

import com.raj.medicall.dto.UserRegisterRequest;

import java.util.Map;

public interface AdminService {
    Map<String,String> registerAdmin(UserRegisterRequest request);
}
