package org.dreamdevzone.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.BaseNotFoundException;
import org.dreamdevzone.hospital.mapper.AdmissionMapper;
import org.dreamdevzone.hospital.model.dto.AdmissionDto;
import org.dreamdevzone.hospital.repository.AdmissionRepository;
import org.dreamdevzone.hospital.service.AdmissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class AdmissionImpl implements AdmissionService {
    private final AdmissionMapper mapper;
    private final AdmissionRepository repository;
    @Override
    public void addAdmission(AdmissionDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public AdmissionDto getAdmission(UUID uuid) {
        return mapper.toDto(repository.findById(uuid).orElseThrow(()-> new BaseNotFoundException("Admission not found!")));
    }

    @Override
    public void deleteAdmission(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public List<AdmissionDto> getAllAdmissions() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public AdmissionDto updateAdmission(AdmissionDto dto, UUID uuid) {
        if(!repository.existsById(uuid)) throw new BaseNotFoundException("Admission not found!");
        dto.setId(uuid);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}
