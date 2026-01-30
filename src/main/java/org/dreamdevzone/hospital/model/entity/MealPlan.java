package org.dreamdevzone.hospital.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "meal_plan")
public class MealPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String mealName;
    private String description;
    private Double calories;
    private Boolean isVegetarian;
    private UUID patientId;
}
