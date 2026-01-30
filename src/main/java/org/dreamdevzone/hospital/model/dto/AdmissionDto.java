package org.dreamdevzone.hospital.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdmissionDto {
    private UUID id;
    @NotBlank(message = "Patient id cannot be empty")
    private UUID patientId;
    @NotBlank(message = "Room id cannot be empty")
    private UUID roomId;
    @NotBlank(message = "Doctor id cannot be empty")
    private UUID doctorId;
    @NotBlank(message = "Date cannot be empty")
    private Date date;
}
