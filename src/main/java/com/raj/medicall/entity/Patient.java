package com.raj.medicall.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "doctors")
@Table(name = "patients")
@PrimaryKeyJoinColumn(name = "id")
public class Patient extends User{
    private  int age;

    private String gender;

    private double height;

    private double weight;

    private String bloodGroup;

    private String allergies;

    private String chronicDiseases;

    private String emergencyContact;

    @ManyToMany(mappedBy = "patients")
    private List<Doctor> doctors;

}
