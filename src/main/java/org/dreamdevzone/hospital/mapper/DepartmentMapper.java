package org.dreamdevzone.hospital.mapper;

import org.dreamdevzone.hospital.model.dto.DepartmentDto;
import org.dreamdevzone.hospital.model.entity.Department;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department toEntity(DepartmentDto departmentDto);
    DepartmentDto toDto(Department department);
    List<DepartmentDto> toDtos(List<Department> departments);
}
