package org.dreamdevzone.hospital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.AdmissionDto;
import org.dreamdevzone.hospital.service.impl.AdmissionImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admission")
public class AdmissionController {
    private final AdmissionImpl service;
    @PostMapping
    public void addAdmission(@Valid @RequestBody AdmissionDto dto){
        service.addAdmission(dto);
    }
    @GetMapping("/{id}")
    public AdmissionDto getAdmission(@PathVariable UUID id){
        return service.getAdmission(id);
    }
    @DeleteMapping("/{id}")
    public void deleteAdmission(@PathVariable UUID id){
        service.deleteAdmission(id);
    }
    @GetMapping
    public List<AdmissionDto> getAllAdmissions(){
        return service.getAllAdmissions();
    }
    @PutMapping("/{id}")
    public AdmissionDto updateAdmission(@Valid @RequestBody AdmissionDto dto, @PathVariable UUID id){
        return service.updateAdmission(dto,id);
    }
}
