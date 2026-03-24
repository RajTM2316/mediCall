package com.raj.medicall.repository;

import com.raj.medicall.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
    List<Consultation> findByPatient_Id(Long patientId);
    List<Consultation> findByDoctor_Id(Long doctorId);
}
