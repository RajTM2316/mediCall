package com.raj.medicall.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@ToString(exclude = "prescriptions")
@AllArgsConstructor
public class Consultation {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultationId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @Getter @Setter
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    @Getter @Setter
    private Doctor doctor;

    @Getter @Setter
    private String diagnosis;

    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL)
    @Getter @Setter
    private List<Prescription> prescriptions;

    @Getter @Setter
    private LocalDate visitDate;

    @Getter @Setter
    private LocalTime visitTime;
}
