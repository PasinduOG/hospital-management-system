package org.dreamdevzone.hospital.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "lab_report")
public class LabReport {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID doctorId;
    private UUID patientId;
    private String result;
    private Date date;
}
