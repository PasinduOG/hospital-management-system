package org.dreamdevzone.hospital.repository;

import org.dreamdevzone.hospital.model.entity.Appointment;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<@NotNull Appointment, @NotNull UUID> {
}
