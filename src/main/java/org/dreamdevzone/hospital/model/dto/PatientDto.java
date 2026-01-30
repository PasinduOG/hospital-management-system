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
@JsonPropertyOrder({"id", "patientId", "bloodGroup", "emergencyContact"})
public class PatientDto {
    private UUID id;
    @NotBlank(message = "Patient id cannot be empty")
    private UUID patientId;
    @NotBlank(message = "Blood group cannot be empty")
    private String bloodGroup;
    @NotBlank(message = "Emergency contact cannot be empty")
    private String emergencyContact;
}
