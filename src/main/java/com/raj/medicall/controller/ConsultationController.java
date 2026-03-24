package com.raj.medicall.controller;

import com.raj.medicall.dto.ConsultationRequest;
import com.raj.medicall.entity.Consultation;
import com.raj.medicall.service.ConsultationService;
import com.raj.medicall.service.ConsultationServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/consult")
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;
    @PostMapping
    public Map<String,String> createConsultation(@RequestBody ConsultationRequest request){
        return consultationService.createConsultation(request);
    }
    @GetMapping("/{id}")
    public Consultation getById(@PathVariable Long id) {
        return consultationService.getById(id);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        consultationService.delete(id);
        return "Consultation deleted successfully";
    }
    @GetMapping("/patient/{id}")
    public ResponseEntity<List<Consultation>> getByPatient(@PathVariable Long id){
        return ResponseEntity.ok(consultationService.getConsultationForPatient(id));
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<List<Consultation>> getByDoctor(@PathVariable Long id){
        return ResponseEntity.ok(consultationService.getConsultationForDoctor(id));
    }
}
