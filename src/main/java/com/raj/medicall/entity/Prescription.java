package com.raj.medicall.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
@NoArgsConstructor
@ToString(exclude = "consultation")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long prescriptionId;

    @ManyToOne
    @JoinColumn(name = "consultation_id",nullable = false)
    @Getter
    @Setter
    @JsonIgnore
    private Consultation consultation;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "medicine_id",nullable = false)
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


    @Getter
    @Setter
    private String notes;

}
