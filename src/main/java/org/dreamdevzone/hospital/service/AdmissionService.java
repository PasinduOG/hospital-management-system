package org.dreamdevzone.hospital.service;

import org.dreamdevzone.hospital.model.dto.AdmissionDto;

import java.util.List;
import java.util.UUID;

public interface AdmissionService {
    void addAdmission(AdmissionDto dto);
    AdmissionDto getAdmission(UUID uuid);
    void deleteAdmission(UUID uuid);
    List<AdmissionDto> getAllAdmissions();
    AdmissionDto updateAdmission(AdmissionDto dto,UUID uuid);
}
