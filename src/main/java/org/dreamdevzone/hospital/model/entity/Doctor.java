package org.dreamdevzone.hospital.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    private UUID id;
    private UUID userId;
    private UUID departmentId;
    private String licenseNumber;
    private String specialization;
}