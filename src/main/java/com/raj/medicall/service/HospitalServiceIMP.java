package com.raj.medicall.service;

import com.raj.medicall.dto.HospitalRegisterRequest;
import com.raj.medicall.entity.Hospital;
import com.raj.medicall.repository.HospitalRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class HospitalServiceIMP implements HospitalService{
    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    @Transactional
    public Map<String, String> registerHospital(HospitalRegisterRequest request) {
        Map<String,String> response = new HashMap<>();
        Hospital hospital=new Hospital();
        hospital.setHospitalName(request.getHospitalName());
        hospital.setHospitalAddress(request.getHospitalAddress());
        hospitalRepository.save(hospital);
        response.put("status", "success");
        response.put("hospitalId", hospital.getHospitalId().toString());
        return response;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalRepository.findAll();
    }
}
