package org.dreamdevzone.hospital.service.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.BaseNotFoundException;
import org.dreamdevzone.hospital.mapper.MealPlanMapper;
import org.dreamdevzone.hospital.model.dto.MealPlanDto;
import org.dreamdevzone.hospital.repository.MealPlanRepository;
import org.dreamdevzone.hospital.service.MealPlanService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MealPlanServiceImpl implements MealPlanService {
    private final MealPlanMapper mapper;
    private final MealPlanRepository repository;

    @Override
    public MealPlanDto addMealPlan(MealPlanDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public MealPlanDto getMealPlan(UUID uuid) {
        return mapper.toDto(repository.findById(uuid)
                .orElseThrow(() -> new BaseNotFoundException("Meal plan not found!")));
    }

    @Override
    public Page<@NotNull MealPlanDto> getAllMealPlans(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
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
