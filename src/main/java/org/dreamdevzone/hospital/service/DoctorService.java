package org.dreamdevzone.hospital.service;

import jakarta.validation.constraints.NotNull;
import org.dreamdevzone.hospital.model.dto.DoctorDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface DoctorService {
    DoctorDto addDoctor(DoctorDto dto);
    DoctorDto searchDoctor(UUID uuid);
    void deleteDoctor(UUID uuid);
    Page<@NotNull DoctorDto> getDoctors(Pageable pageable);
    DoctorDto updateDoctor(DoctorDto dto, UUID uuid);
}
