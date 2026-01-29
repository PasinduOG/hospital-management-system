package org.dreamdevzone.hospital.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
}
