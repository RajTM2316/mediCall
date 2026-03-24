package com.raj.medicall.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Consultation {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @Getter @Setter
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    @Getter @Setter
    private Doctor doctor;

    @Getter @Setter
    private String disease;

    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL)
    @Getter @Setter
    private List<Prescription> prescriptions;

    @Getter @Setter
    private LocalDate visitDate;
}
