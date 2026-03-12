package com.raj.medicall.entity;

import jakarta.persistence.*;
import lombok.*;
import tools.jackson.databind.ser.jdk.JDKKeySerializers;

@Entity
@Table(name = "app_user")
@NoArgsConstructor
@ToString
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @Column(unique = true)
    private String email;

    @Getter
    @Setter
    private String phoneNo;

    @Setter
    @Getter
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Getter
    @Setter
    @Column
    private boolean isActive=true;

}
