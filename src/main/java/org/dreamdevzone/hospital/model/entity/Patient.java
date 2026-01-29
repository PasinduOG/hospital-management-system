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
@Table(name = "patient")
public class Patient {
    @Id
    private UUID id;
    private UUID patientId;
    private String bloodGroup;
    private String emergencyContact;
}
