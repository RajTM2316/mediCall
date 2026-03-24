package com.raj.medicall.service;

import com.raj.medicall.dto.ConsultationRequest;
import com.raj.medicall.entity.Consultation;
import com.raj.medicall.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface ConsultationService {
    Map<String,String> createConsultation(ConsultationRequest request);
    public Consultation getById(Long id);
    public void delete(Long id);
    public List<Consultation> getConsultationForPatient(Long id);
    public List<Consultation> getConsultationForDoctor(Long id);
}
