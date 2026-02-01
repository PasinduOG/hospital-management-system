package org.dreamdevzone.hospital.service;

import jakarta.validation.constraints.NotNull;
import org.dreamdevzone.hospital.model.dto.LabReportDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface LabReportService {
    LabReportDto addLabReport(LabReportDto dto);
    LabReportDto getLabReport(UUID uuid);
    void deleteLabReport(UUID uuid);
    Page<@NotNull LabReportDto> getAllLabReports(Pageable pageable);
    LabReportDto updateLabReport(LabReportDto dto,UUID uuid);
}
