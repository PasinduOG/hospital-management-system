package org.dreamdevzone.hospital.repository;

import org.dreamdevzone.hospital.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentRepository extends JpaRepository<Department, UUID> {
}
