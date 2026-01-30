package org.dreamdevzone.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.BaseNotFoundException;
import org.dreamdevzone.hospital.mapper.BillMapper;
import org.dreamdevzone.hospital.model.dto.BillDto;
import org.dreamdevzone.hospital.repository.BillRepository;
import org.dreamdevzone.hospital.service.BillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {
    private final BillRepository repository;
    private final BillMapper mapper;
    @Override
    public void addBill(BillDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public BillDto getBill(UUID uuid) {
        return mapper.toDto(repository.findById(uuid).orElseThrow(()->new BaseNotFoundException("Bill not found!")));
    }

    @Override
    public void deleteBill(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<BillDto> getAllBills() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public BillDto updateBill(BillDto dto, UUID uuid) {
        if(!repository.existsById(uuid)) throw new BaseNotFoundException("Bill not found!");
        dto.setId(uuid);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}
