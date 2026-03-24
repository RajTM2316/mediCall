package com.raj.medicall.service;

import com.raj.medicall.dto.ConsultationRequest;
import com.raj.medicall.entity.Consultation;
import com.raj.medicall.entity.Doctor;
import com.raj.medicall.entity.Patient;
import com.raj.medicall.exception.ResourceNotFoundException;
import com.raj.medicall.repository.ConsultationRepository;
import com.raj.medicall.repository.DoctorRepository;
import com.raj.medicall.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConsultationServiceIMP implements ConsultationService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    public Map<String,String> createConsultation(ConsultationRequest request) {
        Map<String,String> response = new HashMap<>();
        Long PatientId = request.getPatientId();
        Long DoctorId = request.getDoctorId();

        Patient patient = patientRepository.findById(PatientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient Not Found"));

        Doctor doctor = doctorRepository.findById(DoctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor Not found"));

        Consultation consultation= new Consultation();
        consultation.setDoctor(doctor);
        consultation.setPatient(patient);
        consultation.setDiagnosis(request.getDiagnosis());
        consultation.setVisitTime(request.getVisitTime());
        consultation.setVisitDate(request.getVisitDate());
        response.put("status","Success");
        response.put("message","Consultation Created Successfully !!!");
        return response;

    }
    public List<Consultation> getByPatient(Long patientId) {
        return consultationRepository.findByPatient_Id(patientId);
    }

    public List<Consultation> getByDoctor(Long doctorId) {
        return consultationRepository.findByDoctor_Id(doctorId);
    }

    public Consultation getById(Long id) {
        return consultationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consultation not found"));
    }

    public void delete(Long id) {
        consultationRepository.deleteById(id);
    }
}
