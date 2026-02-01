package org.dreamdevzone.hospital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.MealPlanDto;
import org.dreamdevzone.hospital.service.MealPlanService;
import org.dreamdevzone.hospital.util.ApiResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mealPlan")
public class MealPlanController {
    private final MealPlanService service;

    @PostMapping
    ResponseEntity<@NotNull ApiResponse<MealPlanDto>> addMealPlan(@Valid @RequestBody MealPlanDto dto){
        return ApiResponse.created("Meal plan created!", service.addMealPlan(dto));
    }

    @GetMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<MealPlanDto>> getMealPlan(@PathVariable  UUID id){
        return ApiResponse.success("Meal plan fetched!", service.getMealPlan(id));
    }

    @DeleteMapping
    ResponseEntity<@NotNull ApiResponse<Void>> deleteMealPlan(@Valid @RequestBody MealPlanDto dto){
        service.deleteMealPlan(dto.getId());
        return ApiResponse.success("Meal plan removed!");
    }

    @GetMapping
    public ResponseEntity<@NotNull ApiResponse<Page<@NotNull MealPlanDto>>> getAllMealPlans(Pageable pageable) {
        String message = String.format("Fetched admissions! Page number: %d, Page size: %d", pageable.getPageNumber(), pageable.getPageSize());
        return ApiResponse.success(message, service.getAllMealPlans(pageable));
    }

    @PutMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<MealPlanDto>> updateMealPlan(@Valid @RequestBody MealPlanDto dto, @PathVariable UUID id){
        return ApiResponse.success("Meal plan updated!", service.updateMealPlan(dto, id));
    }
}
