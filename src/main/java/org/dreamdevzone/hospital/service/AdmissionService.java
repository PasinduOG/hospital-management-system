package org.dreamdevzone.hospital.service;

import org.dreamdevzone.hospital.model.dto.AdmissionDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AdmissionService {
    AdmissionDto addAdmission(AdmissionDto dto);
    AdmissionDto getAdmission(UUID uuid);
    void deleteAdmission(UUID uuid);
    Page<@NotNull AdmissionDto> getAllAdmissions(Pageable pageable);
    AdmissionDto updateAdmission(AdmissionDto dto,UUID uuid);
}
