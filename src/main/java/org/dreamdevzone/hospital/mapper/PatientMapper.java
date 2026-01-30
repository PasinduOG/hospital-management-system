package org.dreamdevzone.hospital.mapper;

import org.dreamdevzone.hospital.model.dto.PatientDto;
import org.dreamdevzone.hospital.model.entity.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientDto toDto(Patient patient);
    Patient toEntity(PatientDto patientDto);
}
