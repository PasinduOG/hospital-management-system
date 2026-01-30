package org.dreamdevzone.hospital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.DepartmentDto;
import org.dreamdevzone.hospital.service.impl.DepartmentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentServiceImpl service;
    @PostMapping
    public void addDepartment(@Valid @RequestBody DepartmentDto dto){
        service.addDepartment(dto);
    }
    @GetMapping("/{id}")
    public DepartmentDto searchDepartment(@PathVariable UUID id){
        return service.searchDepartment(id);
    }
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable UUID id){
        service.deleteDepartment(id);
    }
    @GetMapping
    public List<DepartmentDto> getDepartments(){
        return service.getDepartments();
    }
    @PutMapping("/{id}")
    public void updateDepartment(@Valid @RequestBody DepartmentDto dto,@PathVariable UUID id){
        service.updateDepartmnt(dto,id);
    }
}
