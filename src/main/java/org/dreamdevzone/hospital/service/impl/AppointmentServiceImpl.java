package org.dreamdevzone.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.BaseNotFoundException;
import org.dreamdevzone.hospital.mapper.AppointmentMapper;
import org.dreamdevzone.hospital.model.dto.AppointmentDto;
import org.dreamdevzone.hospital.repository.AppointmentRepository;
import org.dreamdevzone.hospital.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
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
    public List<AppointmentDto> getAllAppointments() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public AppointmentDto updateAppointment(AppointmentDto dto, UUID uuid) {
        if (!repository.existsById(uuid)) throw new BaseNotFoundException("Appointment not found!");
        dto.setId(uuid);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}
