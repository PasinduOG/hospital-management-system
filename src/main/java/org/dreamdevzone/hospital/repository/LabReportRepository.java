package org.dreamdevzone.hospital.repository;

import org.dreamdevzone.hospital.model.entity.LabReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LabReportRepository extends JpaRepository<LabReport, UUID> {
    UUID id(UUID id);
}
