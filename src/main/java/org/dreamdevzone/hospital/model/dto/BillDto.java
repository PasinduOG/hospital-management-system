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
public class BillDto {
    private UUID id;
    @NotBlank(message = "Paid amount cannot be empty")
    private Double paymentAmount;
    @NotBlank(message = "Date cannot be empty")
    private Date date;
    @NotBlank(message = "Status cannot be empty")
    private Boolean status;
}
