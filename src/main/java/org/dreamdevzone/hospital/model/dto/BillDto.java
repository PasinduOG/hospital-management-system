package org.dreamdevzone.hospital.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
public class BillDto {
    private UUID id;
    private Double paymentAmount;
    private Date date;
    private Boolean status;
}
