package com.raj.medicall.repository;

import com.raj.medicall.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

    List<Prescription> findByConsultation_Patient_Id(Long patientId);

    List<Prescription> findByConsultation_Doctor_Id(Long doctorId);

    List<Prescription> findByConsultation_ConsultationId(Long consultationId);
}