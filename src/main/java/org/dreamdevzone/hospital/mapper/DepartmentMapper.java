package org.dreamdevzone.hospital.mapper;

import org.dreamdevzone.hospital.model.dto.DepartmentDto;
import org.dreamdevzone.hospital.model.entity.Department;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department toEntity(DepartmentDto departmentDto);
    DepartmentDto toDto(Department department);
}
