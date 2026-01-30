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
@JsonPropertyOrder({"id", "roomNumber", "type", "status"})
public class RoomDto {
    private UUID id;
    @NotBlank(message = "Role cannot be empty")
    private Integer roomNumber;
    @NotBlank(message = "Type cannot be empty")
    private String type;
    @NotBlank(message = "Status cannot be empty")
    private Boolean status;
}
