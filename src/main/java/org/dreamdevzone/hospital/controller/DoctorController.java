package org.dreamdevzone.hospital.controller;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.DoctorDto;
import org.dreamdevzone.hospital.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService service;
    @PostMapping
    public void addDoctor(@RequestBody DoctorDto dto){
        service.addDoctor(dto);
    }
    @GetMapping("/{id}")
    public DoctorDto searchDoctor(@PathVariable UUID id){
        return service.searchDoctor(id);
    }
    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable UUID id){
        service.deleteDoctor(id);
    }
    @GetMapping
    public List<DoctorDto> getDoctor(){
        return service.getDoctors();
    }
    @PostMapping("/{id}")
    public void updateDoctor(@RequestBody DoctorDto dto,@PathVariable UUID id){
        service.updateDoctor(dto,id);
    }
}
