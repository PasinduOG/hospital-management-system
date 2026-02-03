package org.dreamdevzone.hospital.service;

import jakarta.validation.constraints.NotNull;
import org.dreamdevzone.hospital.model.dto.BillDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface BillService {
    BillDto addBill(BillDto dto);
    BillDto getBill(UUID uuid);
    void deleteBill(UUID id);
    Page<@NotNull BillDto> getAllBills(Pageable pageable);
    BillDto updateBill(BillDto dto, UUID uuid);
}
