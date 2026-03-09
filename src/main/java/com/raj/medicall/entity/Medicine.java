package com.raj.medicall.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
name → Paracetamol
type → Tablet
strength → 500mg
manufacturer → Cipla
 */
@Entity
@Table(name = "medicines")
@NoArgsConstructor
@ToString
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long medicineId;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String type;

    @Getter
    @Setter
    private String manufacturer;

    @Getter
    @Setter
    private String strength;

    @Getter
    @Setter
    @Lob
    private String description;


}
