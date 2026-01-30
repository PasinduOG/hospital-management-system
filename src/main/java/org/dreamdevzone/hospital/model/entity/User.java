package org.dreamdevzone.hospital.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.dreamdevzone.hospital.util.Role;

import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
