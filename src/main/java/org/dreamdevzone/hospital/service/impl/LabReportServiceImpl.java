package org.dreamdevzone.hospital.service.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.BaseNotFoundException;
import org.dreamdevzone.hospital.mapper.LabReportMapper;
import org.dreamdevzone.hospital.model.dto.LabReportDto;
import org.dreamdevzone.hospital.repository.LabReportRepository;
import org.dreamdevzone.hospital.service.LabReportService;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class LabReportServiceImpl implements LabReportService {

    private final LabReportRepository repository;
    private final LabReportMapper mapper;

    @Override
    public LabReportDto addLabReport(LabReportDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public LabReportDto getLabReport(UUID uuid) {
        return mapper.toDto(repository.findById(uuid)
                .orElseThrow(() -> new BaseNotFoundException("Lab report not found!")));
    }

    @Override
    public void deleteLabReport(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public Page<@NotNull LabReportDto> getAllLabReports(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public LabReportDto updateLabReport(LabReportDto dto, UUID uuid) {
        if (!repository.existsById(uuid)) throw new BaseNotFoundException("Lab report not found!");
        dto.setId(uuid);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}
