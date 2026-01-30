package org.dreamdevzone.hospital.mapper;

import org.dreamdevzone.hospital.model.dto.DoctorDto;
import org.dreamdevzone.hospital.model.entity.Doctor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    Doctor toEntity(DoctorDto doctorDto);
    DoctorDto toDto(Doctor doctor);
    List<DoctorDto> toDtos(List<Doctor> doctors);
}
