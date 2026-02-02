package org.dreamdevzone.hospital.service.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.BaseNotFoundException;
import org.dreamdevzone.hospital.mapper.RoomMapper;
import org.dreamdevzone.hospital.model.dto.RoomDto;
import org.dreamdevzone.hospital.repository.RoomRepository;
import org.dreamdevzone.hospital.service.RoomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository repository;
    private final RoomMapper mapper;

    @Override
    public RoomDto addRoom(RoomDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public RoomDto getRoom(UUID uuid) {
        return mapper.toDto(repository.findById(uuid)
                .orElseThrow(() -> new BaseNotFoundException("Room not found!")));
    }

    @Override
    public void deleteRoom(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public Page<@NotNull RoomDto> getAllRooms(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public RoomDto updateRoom(RoomDto dto, UUID uuid) {
        if (!repository.existsById(uuid)) throw new BaseNotFoundException("Room not found!");
        dto.setId(uuid);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}
