package org.dreamdevzone.hospital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.DepartmentDto;
import org.dreamdevzone.hospital.service.impl.DepartmentServiceImpl;
import org.dreamdevzone.hospital.util.ApiResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentServiceImpl service;

    @PostMapping
    ResponseEntity<@NotNull ApiResponse<DepartmentDto>> addDepartment(@Valid @RequestBody DepartmentDto dto){
        return ApiResponse.created("Department created!", service.addDepartment(dto));
    }

    @GetMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<DepartmentDto>> searchDepartment(@PathVariable UUID id){
        return ApiResponse.success("Department fetched!", service.searchDepartment(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<Void>> deleteDepartment(@PathVariable UUID id){
        service.deleteDepartment(id);
        return ApiResponse.success("Department removed!");
    }

    @GetMapping
    ResponseEntity<@NotNull ApiResponse<List<DepartmentDto>>> getDepartments(){
        return ApiResponse.success("Fetched departments", service.getDepartments());
    }

    @PutMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<DepartmentDto>> updateDepartment(@Valid @RequestBody DepartmentDto dto,@PathVariable UUID id){
        return ApiResponse.success("Department updated!", service.updateDepartmnt(dto,id));
    }
}
