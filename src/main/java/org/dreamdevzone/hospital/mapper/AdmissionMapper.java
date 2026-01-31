package org.dreamdevzone.hospital.mapper;

import org.dreamdevzone.hospital.model.dto.AdmissionDto;
import org.dreamdevzone.hospital.model.entity.Admission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdmissionMapper {
    Admission toEntity(AdmissionDto admissionDto);
    AdmissionDto toDto(Admission admission);
}
