package org.dreamdevzone.hospital.service;

import jakarta.validation.constraints.NotNull;
import org.dreamdevzone.hospital.model.dto.RoomDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface RoomService {
    RoomDto addRoom(RoomDto dto);
    RoomDto getRoom(UUID uuid);
    void deleteRoom(UUID uuid);
    Page<@NotNull RoomDto> getAllRooms(Pageable pageable);
    RoomDto updateRoom(RoomDto dto,UUID uuid);
}
