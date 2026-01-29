package org.dreamdevzone.hospital.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department {
    @Id
    private UUID id;
    private String name;
}
