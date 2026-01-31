package org.dreamdevzone.hospital.repository;

import org.dreamdevzone.hospital.model.entity.Doctor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<@NotNull Doctor, @NotNull UUID> {
}
