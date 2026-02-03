package org.dreamdevzone.hospital.service;

import jakarta.validation.constraints.NotNull;
import org.dreamdevzone.hospital.model.dto.PatientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PatientService {
    PatientDto addPatient(PatientDto patientDto);
    PatientDto getPatient(UUID id);
    PatientDto updatePatient(PatientDto patientDto, UUID id);
    void deletePatient(UUID id);
    Page<@NotNull PatientDto> getAllPatients(Pageable pageable);
}
