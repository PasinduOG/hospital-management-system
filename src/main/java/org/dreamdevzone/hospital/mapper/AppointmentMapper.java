package org.dreamdevzone.hospital.mapper;

import org.dreamdevzone.hospital.model.dto.AppointmentDto;
import org.dreamdevzone.hospital.model.entity.Appointment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    Appointment toEntity(AppointmentDto appointmentDto);
    AppointmentDto toDto(Appointment appointment);
    List<AppointmentDto> toDtos(List<Appointment> appointments);
}
