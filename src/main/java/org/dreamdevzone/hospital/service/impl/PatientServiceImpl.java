package org.dreamdevzone.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.ResourceNotFoundException;
import org.dreamdevzone.hospital.mapper.PatientMapper;
import org.dreamdevzone.hospital.model.dto.PatientDto;
import org.dreamdevzone.hospital.repository.PatientRepository;
import org.dreamdevzone.hospital.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
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
    public List<PatientDto> getAllPatients() {
        return repository.findAll().stream()
                .map(mapper::toDto).toList();
    }
}
