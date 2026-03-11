package com.raj.medicall.repository;

import com.raj.medicall.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Patient,Long> {
}
