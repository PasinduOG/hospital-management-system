package org.dreamdevzone.hospital.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    private UUID id;
    private UUID patientId;
    private String bloodGroup;
    private String emergencyContact;
}
