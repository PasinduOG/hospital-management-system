package org.dreamdevzone.hospital.service;

import org.dreamdevzone.hospital.model.dto.LabReportDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface LabReportService {
    LabReportDto addLabReport(LabReportDto dto);
    LabReportDto getLabReport(UUID uuid);
    void deleteLabReport(UUID uuid);
    Page<@NotNull LabReportDto> getAllLabReports(Pageable pageable);
    LabReportDto updateLabReport(LabReportDto dto,UUID uuid);
}
