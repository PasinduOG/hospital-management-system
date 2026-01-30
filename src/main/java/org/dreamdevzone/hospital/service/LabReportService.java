package org.dreamdevzone.hospital.service;

import org.dreamdevzone.hospital.model.dto.LabReportDto;

import java.util.List;
import java.util.UUID;

public interface LabReportService {
    LabReportDto addLabReport(LabReportDto dto);
    LabReportDto getLabReport(UUID uuid);
    void deleteLabReport(UUID uuid);
    List<LabReportDto> getAllLabReports();
    LabReportDto updateLabReport(LabReportDto dto,UUID uuid);
}
