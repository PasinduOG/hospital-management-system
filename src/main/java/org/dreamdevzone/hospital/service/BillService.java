package org.dreamdevzone.hospital.service;

import org.dreamdevzone.hospital.model.dto.BillDto;

import java.util.List;
import java.util.UUID;

public interface BillService {
    BillDto addBill(BillDto dto);
    BillDto getBill(UUID uuid);
    void deleteBill(UUID id);
    List<BillDto> getAllBills();
    BillDto updateBill(BillDto dto, UUID uuid);
}
