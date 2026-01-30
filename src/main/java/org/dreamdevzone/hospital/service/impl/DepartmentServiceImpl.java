package org.dreamdevzone.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.BaseNotFoundException;
import org.dreamdevzone.hospital.mapper.DepartmentMapper;
import org.dreamdevzone.hospital.model.dto.DepartmentDto;
import org.dreamdevzone.hospital.repository.DepartmentRepository;
import org.dreamdevzone.hospital.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;

    @Override
    public DepartmentDto addDepartment(DepartmentDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public DepartmentDto searchDepartment(UUID uuid) {
        return mapper.toDto(repository.findById(uuid)
                .orElseThrow(() -> new BaseNotFoundException("Department not found!")));
    }

    @Override
    public void deleteDepartment(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public List<DepartmentDto> getDepartments() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public DepartmentDto updateDepartmnt(DepartmentDto dto, UUID uuid) {
        if (!repository.existsById(uuid)) throw new BaseNotFoundException("Department not found!");
        dto.setId(uuid);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}
