package com.raj.medicall.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "consultations")
@Table(name = "patients")
@PrimaryKeyJoinColumn(name = "id")
public class Patient extends User{
    private  int age;

    private String gender;

    private double height;

    private double weight;

    private String bloodGroup;

    @ElementCollection
    @CollectionTable(name = "patient_allergies", joinColumns = @JoinColumn(name = "patient_id"))
    @Column(name = "allergy")
    private List<String> allergies;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Consultation> consultations;

    private String emergencyContact;

}
