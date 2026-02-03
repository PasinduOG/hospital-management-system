package org.dreamdevzone.hospital.service.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.ResourceNotFoundException;
import org.dreamdevzone.hospital.mapper.DoctorMapper;
import org.dreamdevzone.hospital.model.dto.DoctorDto;
import org.dreamdevzone.hospital.repository.DoctorRepository;
import org.dreamdevzone.hospital.service.DoctorService;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@SuppressWarnings("unused")
public class DoctorServiceImpl implements DoctorService {
    private final DoctorMapper mapper;
    private final DoctorRepository repository;

    @Override
    public DoctorDto addDoctor(DoctorDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public DoctorDto searchDoctor(UUID uuid) {
        return mapper.toDto(repository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found!", HttpStatus.NOT_FOUND)));
    }

    @Override
    public void deleteDoctor(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public Page<@NotNull DoctorDto> getDoctors(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public DoctorDto updateDoctor(DoctorDto dto, UUID id) {
        if (!repository.existsById(id)) throw new ResourceNotFoundException("Doctor not found!", HttpStatus.NOT_FOUND);
        dto.setId(id);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}
