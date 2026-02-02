package org.dreamdevzone.hospital.controller;

import io.github.pasinduog.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.MealPlanDto;
import org.dreamdevzone.hospital.service.MealPlanService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mealPlan")
@SuppressWarnings("unused")  // For hide unused warnings for endpoint methods @SuppressWarnings("unused")
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
    ResponseEntity<@NotNull ApiResponse<List<MealPlanDto>>> getAllMealPlans(){
        return ApiResponse.success("Fetched meal plans!", service.getAllMealPlans());
    }

    @PutMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<MealPlanDto>> updateMealPlan(@Valid @RequestBody MealPlanDto dto, @PathVariable UUID id){
        return ApiResponse.success("Meal plan updated!", service.updateMealPlan(dto, id));
    }
}
