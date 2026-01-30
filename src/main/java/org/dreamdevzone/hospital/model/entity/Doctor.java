package org.dreamdevzone.hospital.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID userId;
    private UUID departmentId;
    private String licenseNumber;
    private String specialization;
}