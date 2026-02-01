package org.dreamdevzone.hospital.service.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.BaseNotFoundException;
import org.dreamdevzone.hospital.mapper.BillMapper;
import org.dreamdevzone.hospital.model.dto.BillDto;
import org.dreamdevzone.hospital.repository.BillRepository;
import org.dreamdevzone.hospital.service.BillService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {
    private final BillRepository repository;
    private final BillMapper mapper;

    @Override
    public BillDto addBill(BillDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public BillDto getBill(UUID uuid) {
        return mapper.toDto(repository.findById(uuid)
                .orElseThrow(() -> new BaseNotFoundException("Bill not found!")));
    }

    @Override
    public void deleteBill(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Page<@NotNull BillDto> getAllBills(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public BillDto updateBill(BillDto dto, UUID uuid) {
        if (!repository.existsById(uuid)) throw new BaseNotFoundException("Bill not found!");
        dto.setId(uuid);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}
