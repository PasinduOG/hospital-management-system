package org.dreamdevzone.hospital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.MealPlanDto;
import org.dreamdevzone.hospital.service.MealPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mealPlan")
public class MealPlanController {
    private final MealPlanService service;
    @PostMapping
    public void addMealPlan(@Valid @RequestBody MealPlanDto dto){
        service.addMealPlan(dto);
    }
    @GetMapping("/{id}")
    public MealPlanDto getMealPlan(@PathVariable  UUID id){
        return service.getMealPlan(id);
    }
    @DeleteMapping
    public void deleteMealPlan(@Valid @RequestBody MealPlanDto dto){
        service.deleteMealPlan(dto.getId());
    }
    @GetMapping
    public List<MealPlanDto> getAllMealPlans(){
        return service.getAllMealPlans();
    }
    @PutMapping("/{id}")
    public MealPlanDto updateMealPlan(@Valid @RequestBody MealPlanDto dto, @PathVariable UUID id){
        return  service.updateMealPlan(dto, id);
    }
}
