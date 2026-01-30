package org.dreamdevzone.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.BaseNotFoundException;
import org.dreamdevzone.hospital.mapper.DoctorMapper;
import org.dreamdevzone.hospital.model.dto.DoctorDto;
import org.dreamdevzone.hospital.repository.DoctorRepository;
import org.dreamdevzone.hospital.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorMapper mapper;
    private final DoctorRepository repository;
    @Override
    public void addDoctor(DoctorDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public DoctorDto searchDoctor(UUID uuid) {
        return mapper.toDto(repository.findById(uuid).orElseThrow(()-> new BaseNotFoundException("Doctor not found!")));
    }

    @Override
    public void deleteDoctor(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public List<DoctorDto> getDoctors() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public void updateDoctor(DoctorDto dto, UUID id) {
        if (!repository.existsById(id)) throw  new BaseNotFoundException("Doctor not found!");
        dto.setId(id);
        repository.save(mapper.toEntity(dto));
    }
}
