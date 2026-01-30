package org.dreamdevzone.hospital.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "admissions")
public class Admission {
    @Id
    private UUID id;
    private UUID patientId;
    private UUID roomId;
    private UUID doctorId;
    private Date date;
}
