package com.raj.medicall.repository;

import com.raj.medicall.entity.Patient;
import com.raj.medicall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Optional<Patient> findByEmail(String email);
    @Query("SELECT p.allergies FROM Patient p WHERE p.id = :patientId")
    List<String> findAllergiesByPatientId(@Param("patientId") Long patientId);
    @Query("SELECT p FROM Patient p WHERE :allergy MEMBER OF p.allergies")
    List<Patient> findByAllergy(@Param("allergy") String allergy);
}
