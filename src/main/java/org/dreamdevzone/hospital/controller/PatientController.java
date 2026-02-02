package org.dreamdevzone.hospital.controller;

import io.github.pasinduog.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.PatientDto;
import org.dreamdevzone.hospital.service.PatientService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
@SuppressWarnings("unused")  // For hide unused warnings for endpoint methods @SuppressWarnings("unused")
public class PatientController {
    private final PatientService service;

    @PostMapping
    ResponseEntity<@NotNull ApiResponse<PatientDto>> add(@Valid @RequestBody PatientDto patientDto){
        return ApiResponse.created("Patient created!", service.addPatient(patientDto));
    }

    @GetMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<PatientDto>> get(@PathVariable UUID id){
        return ApiResponse.success("Patient fetched!", service.getPatient(id));
    }

    @GetMapping
    ResponseEntity<@NotNull ApiResponse<List<PatientDto>>> getAll(){
        return ApiResponse.success("Fetched patients!", service.getAllPatients());
    }

    @PutMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<PatientDto>> update(@Valid @RequestBody PatientDto patientDto, @PathVariable UUID id){
        return ApiResponse.success("Patient updated!", service.updatePatient(patientDto, id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<Void>> remove(@PathVariable UUID id){
        service.deletePatient(id);
        return ApiResponse.success("Patient removed!");
    }
}
