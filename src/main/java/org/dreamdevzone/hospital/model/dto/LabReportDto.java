package org.dreamdevzone.hospital.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "doctorId", "patientId", "result","date"})
public class LabReportDto {
    private UUID id;
    @NotBlank(message = "Doctor id cannot be empty")
    private UUID doctorId;
    @NotBlank(message = "Patient id cannot be empty")
    private UUID patientId;
    @NotBlank(message = "Result cannot be empty")
    private String result;
    @NotBlank(message = "Date cannot be empty")
    private Date date;
}
