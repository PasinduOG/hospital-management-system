package org.dreamdevzone.hospital.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Patient ID cannot be empty")
    private UUID patientId;

    @NotBlank(message = "Blood group cannot be empty")
    private String bloodGroup;

    @NotBlank(message = "Emergency contact cannot be empty")
    private String emergencyContact;
}
