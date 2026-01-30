package org.dreamdevzone.hospital.mapper;

import org.dreamdevzone.hospital.model.dto.LabReportDto;
import org.dreamdevzone.hospital.model.entity.LabReport;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LabReportMapper {
    LabReportDto toDto(LabReport dto);
    LabReport toEntity(LabReportDto labReportDto);
    List<LabReportDto> toEntities(List<LabReport> labReports);
}
