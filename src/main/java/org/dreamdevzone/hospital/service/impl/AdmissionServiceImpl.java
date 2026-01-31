package org.dreamdevzone.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.BaseNotFoundException;
import org.dreamdevzone.hospital.mapper.AdmissionMapper;
import org.dreamdevzone.hospital.model.dto.AdmissionDto;
import org.dreamdevzone.hospital.repository.AdmissionRepository;
import org.dreamdevzone.hospital.service.AdmissionService;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class AdmissionServiceImpl implements AdmissionService {
    private final AdmissionMapper mapper;
    private final AdmissionRepository repository;

    @Override
    public AdmissionDto addAdmission(AdmissionDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public AdmissionDto getAdmission(UUID uuid) {
        return mapper.toDto(repository.findById(uuid)
                .orElseThrow(() -> new BaseNotFoundException("Admission not found!")));
    }

    @Override
    public void deleteAdmission(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public Page<@NotNull AdmissionDto> getAllAdmissions(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public AdmissionDto updateAdmission(AdmissionDto dto, UUID uuid) {
        if (!repository.existsById(uuid)) throw new BaseNotFoundException("Admission not found!");
        dto.setId(uuid);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}
