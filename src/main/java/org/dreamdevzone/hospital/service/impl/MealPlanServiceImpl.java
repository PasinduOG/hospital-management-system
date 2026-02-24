package org.dreamdevzone.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.ResourceNotFoundException;
import org.dreamdevzone.hospital.mapper.MealPlanMapper;
import org.dreamdevzone.hospital.model.dto.MealPlanDto;
import org.dreamdevzone.hospital.repository.MealPlanRepository;
import org.dreamdevzone.hospital.service.MealPlanService;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@SuppressWarnings("unused")
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
                .orElseThrow(() -> new ResourceNotFoundException("Meal plan not found!", HttpStatus.NOT_FOUND)));
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
        if (!repository.existsById(uuid)) throw new ResourceNotFoundException("Meal plan not found", HttpStatus.NOT_FOUND);
        dto.setId(uuid);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}
