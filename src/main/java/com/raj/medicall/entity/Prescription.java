package com.raj.medicall.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
@NoArgsConstructor
@ToString
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long prescriptionId;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @Getter
    @Setter
    private Patient patient;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    @Getter
    @Setter
    private String dosage;

    @Getter
    @Setter
    private String frequency;

    @Getter
    @Setter
    private LocalTime timeToTake;

    @Getter
    @Setter
    private LocalDate startDate;

    @Getter
    @Setter
    private LocalDate endDate;

    @Lob
    @Getter
    @Setter
    private String notes;

}
