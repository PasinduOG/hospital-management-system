package org.dreamdevzone.hospital.controller;

import io.github.pasinduog.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.DepartmentDto;
import org.dreamdevzone.hospital.service.DepartmentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
@SuppressWarnings("unused") // For hide unused warnings for endpoint methods @SuppressWarnings("unused")
public class DepartmentController {
    private final DepartmentService service;

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
    ResponseEntity<@NotNull ApiResponse<Page<@NotNull DepartmentDto>>> getDepartments(Pageable pageable){
        String message = String.format("Fetched departments! Page number: %d, Page size: %d", pageable.getPageNumber(), pageable.getPageSize());
        return ApiResponse.success(message, service.getDepartments(pageable));
    }

    @PutMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<DepartmentDto>> updateDepartment(@Valid @RequestBody DepartmentDto dto,@PathVariable UUID id){
        return ApiResponse.success("Department updated!", service.updateDepartmnt(dto,id));
    }
}
