package org.dreamdevzone.hospital.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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