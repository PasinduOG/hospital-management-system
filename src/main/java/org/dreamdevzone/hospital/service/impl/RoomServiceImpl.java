package org.dreamdevzone.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.ResourceNotFoundException;
import org.dreamdevzone.hospital.mapper.RoomMapper;
import org.dreamdevzone.hospital.model.dto.RoomDto;
import org.dreamdevzone.hospital.repository.RoomRepository;
import org.dreamdevzone.hospital.service.RoomService;
import org.springframework.http.HttpStatus;
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
                .orElseThrow(() -> new ResourceNotFoundException("Room not found!", HttpStatus.NOT_FOUND)));
    }

    @Override
    public void deleteRoom(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public List<RoomDto> getAllRooms() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public RoomDto updateRoom(RoomDto dto, UUID uuid) {
        if (!repository.existsById(uuid)) throw new ResourceNotFoundException("Room not found!", HttpStatus.NOT_FOUND);
        dto.setId(uuid);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}
