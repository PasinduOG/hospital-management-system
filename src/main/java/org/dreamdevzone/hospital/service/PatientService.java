package org.dreamdevzone.hospital.service;

import org.dreamdevzone.hospital.model.dto.PatientDto;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    PatientDto addPatient(PatientDto patientDto);
    PatientDto getPatient(UUID id);
    PatientDto updatePatient(PatientDto patientDto, UUID id);
    void deletePatient(UUID id);
    List<PatientDto> getAllPatients();
}
