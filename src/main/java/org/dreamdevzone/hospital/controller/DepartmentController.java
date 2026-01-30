package org.dreamdevzone.hospital.controller;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.DepartmentDto;
import org.dreamdevzone.hospital.service.impl.DepartmentImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentImpl service;
    @PostMapping
    public void addDepartment(@RequestBody DepartmentDto dto){
        service.addDepartment(dto);
    }
    @PostMapping("/{id}")
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
    @PostMapping("/{id}")
    public void updateDepartment(@RequestBody DepartmentDto dto,@PathVariable UUID id){
        service.updateDepartmnt(dto,id);
    }
}
