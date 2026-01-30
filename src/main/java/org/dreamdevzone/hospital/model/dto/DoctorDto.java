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
@JsonPropertyOrder({"id", "userId", "departmentId", "licenseNumber", "specialization"})
public class DoctorDto {
    private UUID id;
    @NotBlank(message = "User ID cannot be empty")
    private UUID userId;
    @NotBlank(message = "Department ID cannot be empty")
    private UUID departmentId;
    @NotBlank(message = "License number cannot be empty")
    private String licenseNumber;
    @NotBlank(message = "Specialization cannot be empty")
    private String specialization;
}
