package org.dreamdevzone.hospital.service;

import org.dreamdevzone.hospital.model.dto.MealPlanDto;

import java.util.List;
import java.util.UUID;

public interface MealPlanService {
    MealPlanDto addMealPlan(MealPlanDto dto);
    MealPlanDto getMealPlan(UUID uuid);
    List<MealPlanDto> getAllMealPlans();
    void deleteMealPlan(UUID uuid);
    MealPlanDto updateMealPlan(MealPlanDto dto,UUID uuid);
}
