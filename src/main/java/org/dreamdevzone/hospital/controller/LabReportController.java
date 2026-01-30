package org.dreamdevzone.hospital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.LabReportDto;
import org.dreamdevzone.hospital.service.LabReportService;
import org.dreamdevzone.hospital.util.ApiResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/labReport")
public class LabReportController {
    private final LabReportService service;

    @PostMapping
    ResponseEntity<@NotNull ApiResponse<LabReportDto>> addLabReport(@Valid @RequestBody LabReportDto dto){
        return ApiResponse.created("Lab report created!", service.addLabReport(dto));
    }

    @GetMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<LabReportDto>> searchLabReport(@PathVariable UUID id){
        return ApiResponse.success("Lab report fetched!", service.getLabReport(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<Void>> deleteLabReport(@PathVariable UUID id){
        service.deleteLabReport(id);
        return ApiResponse.success("Lab report removed!");
    }

    @GetMapping
    ResponseEntity<@NotNull ApiResponse<List<LabReportDto>>> getAllLabReports(){
        return ApiResponse.success("Fetched lab reports!", service.getAllLabReports());
    }

    @PutMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<LabReportDto>> updateLabReport(@Valid @RequestBody LabReportDto dto, @PathVariable UUID id){
        return ApiResponse.success("Lab report updated!", service.updateLabReport(dto,id));
    }
}
