package org.dreamdevzone.hospital.controller;

import io.github.pasinduog.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.LabReportDto;
import org.dreamdevzone.hospital.service.LabReportService;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/labReport")
@SuppressWarnings("unused") // For hide unused warnings for endpoint methods @SuppressWarnings("unused")
public class LabReportController {
    private final LabReportService service;

    @PostMapping
    ResponseEntity<@NotNull ApiResponse<LabReportDto>> addLabReport(@Valid @RequestBody LabReportDto dto) {
        return ApiResponse.created("Lab report created!", service.addLabReport(dto));
    }

    @GetMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<LabReportDto>> searchLabReport(@PathVariable UUID id) {
        return ApiResponse.success("Lab report fetched!", service.getLabReport(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<Void>> deleteLabReport(@PathVariable UUID id) {
        service.deleteLabReport(id);
        return ApiResponse.success("Lab report removed!");
    }

    @GetMapping
    ResponseEntity<@NotNull ApiResponse<Page<@NotNull LabReportDto>>> getAllLabReports(Pageable pageable) {
        String message = String.format("Fetched lab reports! Page number: %d, Page size: %d", pageable.getPageNumber(), pageable.getPageSize());
        return ApiResponse.success(message, service.getAllLabReports(pageable));
    }

    @PutMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<LabReportDto>> updateLabReport(@Valid @RequestBody LabReportDto dto, @PathVariable UUID id) {
        return ApiResponse.success("Lab report updated!", service.updateLabReport(dto, id));
    }
}
