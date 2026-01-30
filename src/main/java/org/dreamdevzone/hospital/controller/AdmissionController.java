package org.dreamdevzone.hospital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.AdmissionDto;
import org.dreamdevzone.hospital.service.AdmissionService;
import org.dreamdevzone.hospital.util.ApiResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admission")
public class AdmissionController {
    private final AdmissionService service;

    @PostMapping
    ResponseEntity<@NotNull ApiResponse<AdmissionDto>> addAdmission(@Valid @RequestBody AdmissionDto dto) {
        return ApiResponse.created("Admission created!", service.addAdmission(dto));
    }

    @GetMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<AdmissionDto>> getAdmission(@PathVariable UUID id) {
        return ApiResponse.success("Admission fetched!", service.getAdmission(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<Void>> deleteAdmission(@PathVariable UUID id) {
        service.deleteAdmission(id);
        return ApiResponse.success("Admission removed!");
    }

    @GetMapping
    public ResponseEntity<@NotNull ApiResponse<List<AdmissionDto>>> getAllAdmissions() {
        return ApiResponse.success("Fetched admissions!", service.getAllAdmissions());
    }

    @PutMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<AdmissionDto>> updateAdmission(@Valid @RequestBody AdmissionDto dto, @PathVariable UUID id) {
        return ApiResponse.success("Admission updated!", service.updateAdmission(dto, id));
    }
}
