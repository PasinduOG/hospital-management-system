package org.dreamdevzone.hospital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.AppointmentDto;
import org.dreamdevzone.hospital.service.impl.AppointmentImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentImpl service;
    @PostMapping
    public void addAppointment(@Valid @RequestBody AppointmentDto dto){
        service.addAppointment(dto);
    }
    @GetMapping("/{id}")
    public AppointmentDto getAppointment(@PathVariable UUID id){
        return service.getAppointment(id);
    }
    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable UUID id){
        service.deleteAppointment(id);
    }
    @GetMapping
    public List<AppointmentDto> getAllAppointments(){
        return service.getAllAppointments();
    }
    @PutMapping("/{id}")
    public AppointmentDto updateAppointment(@Valid @RequestBody AppointmentDto dto,@PathVariable UUID id){
        return service.updateAppointment(dto,id);
    }
}
