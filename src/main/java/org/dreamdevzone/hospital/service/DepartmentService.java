package org.dreamdevzone.hospital.service;

import org.dreamdevzone.hospital.model.dto.DepartmentDto;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {
    void addDepartment(DepartmentDto dto);
    DepartmentDto searchDepartment(UUID uuid);
    void deleteDepartment(UUID uuid);
    List<DepartmentDto> getDepartments();
}
