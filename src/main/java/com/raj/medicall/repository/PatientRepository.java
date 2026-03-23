package com.raj.medicall.repository;

import com.raj.medicall.entity.Patient;
import com.raj.medicall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
