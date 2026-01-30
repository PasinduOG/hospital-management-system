package org.dreamdevzone.hospital.service;

import org.dreamdevzone.hospital.model.dto.DoctorDto;

import java.util.List;
import java.util.UUID;

public interface DoctorService {
    DoctorDto addDoctor(DoctorDto dto);
    DoctorDto searchDoctor(UUID uuid);
    void deleteDoctor(UUID uuid);
    List<DoctorDto> getDoctors();
    DoctorDto updateDoctor(DoctorDto dto, UUID uuid);
}
