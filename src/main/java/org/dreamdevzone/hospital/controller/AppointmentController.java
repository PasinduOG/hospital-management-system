package org.dreamdevzone.hospital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.AppointmentDto;
import org.dreamdevzone.hospital.service.AppointmentService;
import org.dreamdevzone.hospital.util.ApiResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService service;

    @PostMapping
    ResponseEntity<@NotNull ApiResponse<AppointmentDto>> addAppointment(@Valid @RequestBody AppointmentDto dto){
        return ApiResponse.created("Appointment created!", service.addAppointment(dto));
    }

    @GetMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<AppointmentDto>> getAppointment(@PathVariable UUID id){
        return ApiResponse.success("Appointment fetched!", service.getAppointment(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<Void>> deleteAppointment(@PathVariable UUID id){
        service.deleteAppointment(id);
        return ApiResponse.success("Appointment removed!");
    }

    @GetMapping
    ResponseEntity<@NotNull ApiResponse<List<AppointmentDto>>> getAllAppointments(){
        return ApiResponse.success("Fetched appointments!", service.getAllAppointments());
    }

    @PutMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<AppointmentDto>> updateAppointment(@Valid @RequestBody AppointmentDto dto,@PathVariable UUID id){
        return ApiResponse.success("Appointment updated!", service.updateAppointment(dto,id));
    }
}
