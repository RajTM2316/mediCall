package com.raj.medicall.controller;

import com.raj.medicall.entity.Prescription;
import com.raj.medicall.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;


    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getById(@PathVariable Long id) {
        return ResponseEntity.ok(prescriptionService.getById(id));
    }


    @GetMapping
    public ResponseEntity<List<Prescription>> getAll() {
        return ResponseEntity.ok(prescriptionService.getAll());
    }

    @GetMapping("/consultation/{id}")
        public ResponseEntity<List<Prescription>> getByConsultationId(@PathVariable Long id){
        return ResponseEntity.ok(prescriptionService.getByConsultationId(id));
        }
    @GetMapping("/patient/{id}")
    public List<Prescription> getByPatient(@PathVariable Long id) {
        return prescriptionService.getByPatientId(id);
    }
    @GetMapping("/doctor/{id}")
    public List<Prescription> getByDoctor(@PathVariable Long id) {
        return prescriptionService.getByDoctorId(id);
    }
}