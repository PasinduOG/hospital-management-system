package org.dreamdevzone.hospital.repository;

import org.dreamdevzone.hospital.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppointmentsRepository extends JpaRepository<Appointment, UUID> {
}
