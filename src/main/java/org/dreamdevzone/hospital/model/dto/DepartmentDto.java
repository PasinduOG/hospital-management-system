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
@JsonPropertyOrder({"id", "name"})
public class DepartmentDto {
    private UUID id;
    @NotBlank(message = "Department name cannot be empty")
    private String name;
}
