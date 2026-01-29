package org.dreamdevzone.hospital.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "User ID cannot be empty")
    private UUID userId;

    @NotBlank(message = "Department ID cannot be empty")
    private UUID departmentId;

    @NotBlank(message = "License number cannot be empty")
    private String licenseNumber;

    @NotBlank(message = "Specialization cannot be empty")
    private String specialization;
}