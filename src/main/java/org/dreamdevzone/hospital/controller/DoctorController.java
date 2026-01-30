package org.dreamdevzone.hospital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.DoctorDto;
import org.dreamdevzone.hospital.service.DoctorService;
import org.dreamdevzone.hospital.util.ApiResponse;
import org.jetbrains.annotations.NotNull;
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
    ResponseEntity<@NotNull ApiResponse<List<DoctorDto>>> getDoctor(){
        return ApiResponse.success("Fetched doctors!", service.getDoctors());
    }

    @PutMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<DoctorDto>> updateDoctor(@Valid @RequestBody DoctorDto dto, @PathVariable UUID id){
        return ApiResponse.success("Doctor updated!", service.updateDoctor(dto,id));
    }
}
