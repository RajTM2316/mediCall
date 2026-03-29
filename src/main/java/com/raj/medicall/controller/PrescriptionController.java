package com.raj.medicall.controller;

import com.raj.medicall.dto.ReschedulePrescriptionRequest;
import com.raj.medicall.dto.UpdatePrescription;
import com.raj.medicall.entity.Prescription;
import com.raj.medicall.service.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/upd/{id}")
    public ResponseEntity<Prescription> updatePrescription(@Valid @RequestBody UpdatePrescription updated, @PathVariable Long id){
        return ResponseEntity.ok(prescriptionService.updatePrescription(updated,id));
    }
    @PutMapping("/upd/reschedule/{id}")
    public ResponseEntity<Prescription> reschedulePrescription(@Valid @RequestBody ReschedulePrescriptionRequest updated, @PathVariable Long id){
        return ResponseEntity.ok(prescriptionService.rescheduledPrescription(updated,id));
    }
    @DeleteMapping("/upd/remove/{id}")
    public String deletePrescription(@PathVariable Long id){
        return prescriptionService.deletePrescription(id);
    }

}