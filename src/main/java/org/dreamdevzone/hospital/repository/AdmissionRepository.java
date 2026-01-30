package org.dreamdevzone.hospital.repository;

import org.dreamdevzone.hospital.model.entity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdmissionRepository extends JpaRepository<Admission, UUID> {
}
