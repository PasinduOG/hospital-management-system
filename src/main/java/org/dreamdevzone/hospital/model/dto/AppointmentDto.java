package org.dreamdevzone.hospital.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentDto {
    private UUID id;
    private UUID patientId;
    private UUID doctorId;
    private Date date;
    private Boolean status;
}
