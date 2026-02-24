package org.dreamdevzone.hospital.service;

import org.dreamdevzone.hospital.model.dto.AppointmentDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AppointmentService {
    AppointmentDto addAppointment(AppointmentDto dto);
    AppointmentDto getAppointment(UUID uuid);
    void deleteAppointment(UUID uuid);
    Page<@NotNull AppointmentDto> getAllAppointments(Pageable pageable);
    AppointmentDto updateAppointment(AppointmentDto dto,UUID uuid);
}
