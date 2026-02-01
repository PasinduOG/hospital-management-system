package org.dreamdevzone.hospital.mapper;

import org.dreamdevzone.hospital.model.dto.AppointmentDto;
import org.dreamdevzone.hospital.model.entity.Appointment;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    Appointment toEntity(AppointmentDto appointmentDto);
    AppointmentDto toDto(Appointment appointment);
}
