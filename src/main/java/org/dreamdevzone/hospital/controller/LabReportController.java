package org.dreamdevzone.hospital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.LabReportDto;
import org.dreamdevzone.hospital.service.LabReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/labReport")
public class LabReportController {
    private final LabReportService service;
    @PostMapping
    public void addLabReport(@Valid @RequestBody LabReportDto dto){
        service.addLabReport(dto);
    }
    @GetMapping("/{id}")
    public LabReportDto searchLabReport(@PathVariable UUID id){
        return service.getLabReport(id);
    }
    @DeleteMapping("/{id}")
    public void deleteLabReport(@PathVariable UUID id){
        service.deleteLabReport(id);
    }
    @GetMapping
    public List<LabReportDto> getAllLabReports(){
        return service.getAllLabReports();
    }
    @PutMapping("/{id}")
    public LabReportDto updateLabReport(@Valid @RequestBody LabReportDto dto,@PathVariable UUID id){
        return service.updateLabReport(dto,id);
    }
}
