package com.raj.medicall.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "doctors")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@PrimaryKeyJoinColumn(name = "id")
public class Doctor extends User{
    private String qualification;

    private String specialization;

    private int expYears;

    private String licenceNumber;

    private String department;

    private double consultationFee;

    @ManyToOne
    @JoinColumn(name="hospital_id")
    private Hospital hospital;

    @ManyToMany
    @JoinTable(
            name = "doctor_patient",
            joinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id")
    )
    private List<Patient> patients;

}
