package org.dreamdevzone.hospital.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "patientId", "bloodGroup", "emergencyContact"})
public class PatientDto {
    private UUID id;
    private UUID patientId;
    private String bloodGroup;
    private String emergencyContact;
}
