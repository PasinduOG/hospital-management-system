package org.dreamdevzone.hospital.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "userId", "departmentId", "licenseNumber", "specialization"})
public class DoctorDto {
    private UUID id;
    private UUID userId;
    private UUID departmentId;
    private String licenseNumber;
    private String specialization;
}
