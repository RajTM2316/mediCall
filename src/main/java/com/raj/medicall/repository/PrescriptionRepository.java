package com.raj.medicall.repository;

import com.raj.medicall.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    List<Prescription> findByConsultation_Patient_Id(Long id);

    List<Prescription> findByConsultation_Doctor_Id(Long id);

    List<Prescription> findByConsultation_ConsultationId(Long consultationId);
}