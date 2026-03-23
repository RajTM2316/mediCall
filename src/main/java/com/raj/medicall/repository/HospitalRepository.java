package com.raj.medicall.repository;

import com.raj.medicall.entity.Hospital;
import com.raj.medicall.entity.Patient;
import com.raj.medicall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {
}
