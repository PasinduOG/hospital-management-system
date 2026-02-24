package org.dreamdevzone.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.ResourceNotFoundException;
import org.dreamdevzone.hospital.mapper.PatientMapper;
import org.dreamdevzone.hospital.model.dto.PatientDto;
import org.dreamdevzone.hospital.repository.PatientRepository;
import org.dreamdevzone.hospital.service.PatientService;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class PatientServiceImpl implements PatientService {
    private final PatientRepository repository;
    private final PatientMapper mapper;

    @Override
    public PatientDto addPatient(PatientDto patientDto) {
        return mapper.toDto(repository.save(mapper.toEntity(patientDto)));
    }

    @Override
    public PatientDto getPatient(UUID id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found!", HttpStatus.NOT_FOUND)));
    }

    @Override
    public PatientDto updatePatient(PatientDto patientDto, UUID id) {
        if (!repository.existsById(id)) throw new ResourceNotFoundException("Patient not found!", HttpStatus.NOT_FOUND);
        patientDto.setPatientId(id);
        return mapper.toDto(repository.save(mapper.toEntity(patientDto)));
    }

    @Override
    public void deletePatient(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Page<@NotNull PatientDto> getAllPatients(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }
}
