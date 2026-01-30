package org.dreamdevzone.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.BaseNotFoundException;
import org.dreamdevzone.hospital.mapper.LabReportMapper;
import org.dreamdevzone.hospital.model.dto.LabReportDto;
import org.dreamdevzone.hospital.repository.LabReportRepository;
import org.dreamdevzone.hospital.service.LabReportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class LabReportServiceImpl implements LabReportService {
    private final LabReportRepository repository;
    private final LabReportMapper mapper;
    @Override
    public void addLabReport(LabReportDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public LabReportDto getLabReport(UUID uuid) {
        return mapper.toDto(repository.findById(uuid).orElseThrow(()->new BaseNotFoundException("Lab report not found!")));
    }

    @Override
    public void deleteLabReport(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public List<LabReportDto> getAllLabReports() {
        return mapper.toEntities(repository.findAll());
    }

    @Override
    public LabReportDto updateLabReport(LabReportDto dto, UUID uuid) {
        if (!repository.existsById(uuid)) throw  new BaseNotFoundException("Lab report not found!");
        dto.setId(uuid);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}
