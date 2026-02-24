package org.dreamdevzone.hospital.service;

import org.dreamdevzone.hospital.model.dto.MealPlanDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface MealPlanService {
    MealPlanDto addMealPlan(MealPlanDto dto);
    MealPlanDto getMealPlan(UUID uuid);
    Page<@NotNull MealPlanDto> getAllMealPlans(Pageable pageable);
    void deleteMealPlan(UUID uuid);
    MealPlanDto updateMealPlan(MealPlanDto dto,UUID uuid);
}
