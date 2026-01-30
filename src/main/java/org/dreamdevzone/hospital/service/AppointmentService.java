package org.dreamdevzone.hospital.service;

import org.dreamdevzone.hospital.model.dto.AppointmentDto;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {
    AppointmentDto addAppointment(AppointmentDto dto);
    AppointmentDto getAppointment(UUID uuid);
    void deleteAppointment(UUID uuid);
    List<AppointmentDto> getAllAppointments();
    AppointmentDto updateAppointment(AppointmentDto dto,UUID uuid);
}
