package org.dreamdevzone.hospital.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "mealName", "description", "calories","isVegetarian","patientId"})
public class MealPlanDto {
    private UUID id;
    @NotBlank(message = "Meal name cannot be empty")
    private String mealName;
    @NotBlank(message = "Description cannot be empty")
    private String description;
    @NotBlank(message = "Calories count cannot be empty")
    private Double calories;
    @NotBlank(message = "Vegetarian status cannot be empty")
    private Boolean isVegetarian;
    @NotBlank(message = "Patient id cannot be empty")
    private UUID patientId;
}
