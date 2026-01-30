package org.dreamdevzone.hospital.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
public class AppointmentDto {
    private UUID id;
    private UUID patientId;
    private UUID doctorId;
    private Date date;
    private Boolean status;
}
