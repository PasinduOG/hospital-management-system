package org.dreamdevzone.hospital.service;

import jakarta.validation.constraints.NotNull;
import org.dreamdevzone.hospital.model.dto.DepartmentDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface DepartmentService {
    DepartmentDto addDepartment(DepartmentDto dto);
    DepartmentDto searchDepartment(UUID uuid);
    void deleteDepartment(UUID uuid);
    Page<@NotNull DepartmentDto> getDepartments(Pageable pageable);
    DepartmentDto updateDepartmnt(DepartmentDto dto, UUID uuid);
}
