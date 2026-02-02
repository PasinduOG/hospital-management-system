package org.dreamdevzone.hospital.service.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.BaseNotFoundException;
import org.dreamdevzone.hospital.mapper.AppointmentMapper;
import org.dreamdevzone.hospital.model.dto.AppointmentDto;
import org.dreamdevzone.hospital.repository.AppointmentRepository;
import org.dreamdevzone.hospital.service.AppointmentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository repository;
    private final AppointmentMapper mapper;

    @Override
    public AppointmentDto addAppointment(AppointmentDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public AppointmentDto getAppointment(UUID uuid) {
        return mapper.toDto(repository.findById(uuid).
                orElseThrow(() -> new BaseNotFoundException("Appointment not found!")));
    }

    @Override
    public void deleteAppointment(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public Page<@NotNull AppointmentDto> getAllAppointments(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public AppointmentDto updateAppointment(AppointmentDto dto, UUID uuid) {
        if (!repository.existsById(uuid)) throw new BaseNotFoundException("Appointment not found!");
        dto.setId(uuid);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}
