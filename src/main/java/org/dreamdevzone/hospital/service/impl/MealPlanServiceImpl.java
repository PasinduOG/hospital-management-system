package org.dreamdevzone.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.ResourceNotFoundException;
import org.dreamdevzone.hospital.mapper.MealPlanMapper;
import org.dreamdevzone.hospital.model.dto.MealPlanDto;
import org.dreamdevzone.hospital.repository.MealPlanRepository;
import org.dreamdevzone.hospital.service.MealPlanService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .orElseThrow(() -> new ResourceNotFoundException("Meal plan not found!", HttpStatus.NOT_FOUND)));
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
        if (!repository.existsById(uuid)) throw new ResourceNotFoundException("Meal plan not found", HttpStatus.NOT_FOUND);
        dto.setId(uuid);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}
