package org.dreamdevzone.hospital.repository;

import org.dreamdevzone.hospital.model.entity.Patient;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<@NotNull Patient, @NotNull UUID> {
}
