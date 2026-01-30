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
public class DepartmentImpl implements DepartmentService {
    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;
    @Override
    public void addDepartment(DepartmentDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public DepartmentDto searchDepartment(UUID uuid) {
        return mapper.toDto(repository.findById(uuid).orElseThrow(()-> new BaseNotFoundException("Department not found!")));
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
    public void updateDepartmnt(DepartmentDto dto, UUID uuid) {
        if(!repository.existsById(uuid)) throw new BaseNotFoundException("Department not found!");
        dto.setId(uuid);
        repository.save(mapper.toEntity(dto));
    }
}
