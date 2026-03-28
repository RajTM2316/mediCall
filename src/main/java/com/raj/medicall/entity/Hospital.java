package com.raj.medicall.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "hospitals")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long hospitalId;

    @Getter
    @Setter
    @Column(nullable = false)
    private String hospitalName;

    @Getter
    @Setter
    @Column(columnDefinition = "TEXT")
    private String hospitalAddress;

}
