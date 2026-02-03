package org.dreamdevzone.hospital.mapper;

import org.dreamdevzone.hospital.model.dto.MealPlanDto;
import org.dreamdevzone.hospital.model.entity.MealPlan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MealPlanMapper {
    MealPlanDto toDto(MealPlan mealPlan);
    MealPlan toEntity(MealPlanDto mealPlanDto);
}
