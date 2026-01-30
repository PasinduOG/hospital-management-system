package org.dreamdevzone.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.mapper.DoctorMapper;
import org.dreamdevzone.hospital.model.dto.DoctorDto;
import org.dreamdevzone.hospital.repository.DoctorRepository;
import org.dreamdevzone.hospital.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class DoctorImpl implements DoctorService {
    private final DoctorMapper mapper;
    private final DoctorRepository repository;
    @Override
    public void addDoctor(DoctorDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public DoctorDto searchDoctor(UUID uuid) {
        return mapper.toDto(repository.findById(uuid).get());
    }

    @Override
    public void deleteDoctor(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public List<DoctorDto> getDoctors() {
        return mapper.toDtos(repository.findAll());
    }
}
