package org.dreamdevzone.hospital.repository;

import org.dreamdevzone.hospital.model.entity.MealPlan;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MealPlanRepository extends JpaRepository<@NotNull MealPlan, @NotNull UUID> {
}
