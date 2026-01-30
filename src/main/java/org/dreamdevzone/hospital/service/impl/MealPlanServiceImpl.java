package org.dreamdevzone.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.BaseNotFoundException;
import org.dreamdevzone.hospital.mapper.MealPlanMapper;
import org.dreamdevzone.hospital.model.dto.MealPlanDto;
import org.dreamdevzone.hospital.repository.MealPlanRepository;
import org.dreamdevzone.hospital.service.MealPlanService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MealPlanServiceImpl implements MealPlanService{
    private final MealPlanMapper mapper;
    private final MealPlanRepository repository;
    @Override
    public void addMealPlan(MealPlanDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public MealPlanDto getMealPlan(UUID uuid) {
        return mapper.toDto(repository.findById(uuid).orElseThrow(()->new BaseNotFoundException("Meal plan not found!")));
    }

    @Override
    public List<MealPlanDto> getAllMealPlans() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public void deleteMealPlan(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public MealPlanDto updateMealPlan(MealPlanDto dto, UUID uuid) {
        if (!repository.existsById(uuid)) throw new BaseNotFoundException("Meal plan not found");
        dto.setId(uuid);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}
