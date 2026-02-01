package org.dreamdevzone.hospital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.AdmissionDto;
import org.dreamdevzone.hospital.model.dto.DoctorDto;
import org.dreamdevzone.hospital.service.DoctorService;
import org.dreamdevzone.hospital.util.ApiResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService service;

    @PostMapping
    ResponseEntity<@NotNull ApiResponse<DoctorDto>> addDoctor(@Valid @RequestBody DoctorDto dto){
        return ApiResponse.created("Doctor created!", service.addDoctor(dto));
    }

    @GetMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<DoctorDto>> searchDoctor(@PathVariable UUID id){
        return ApiResponse.success("Doctor fetched!", service.searchDoctor(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<Void>> deleteDoctor(@PathVariable UUID id){
        service.deleteDoctor(id);
        return ApiResponse.success("Doctor removed!");
    }

    @GetMapping
    public ResponseEntity<@NotNull ApiResponse<Page<@NotNull DoctorDto>>> getAllDoctors(Pageable pageable) {
        String message = String.format("Fetched admissions! Page number: %d, Page size: %d", pageable.getPageNumber(), pageable.getPageSize());
        return ApiResponse.success(message, service.getDoctors(pageable));
    }

    @PutMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<DoctorDto>> updateDoctor(@Valid @RequestBody DoctorDto dto, @PathVariable UUID id){
        return ApiResponse.success("Doctor updated!", service.updateDoctor(dto,id));
    }
}
