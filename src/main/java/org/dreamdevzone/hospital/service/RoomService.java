package org.dreamdevzone.hospital.service;

import org.dreamdevzone.hospital.model.dto.RoomDto;

import java.util.List;
import java.util.UUID;

public interface RoomService {
    RoomDto addRoom(RoomDto dto);
    RoomDto getRoom(UUID uuid);
    void deleteRoom(UUID uuid);
    List<RoomDto> getAllRooms();
    RoomDto updateRoom(RoomDto dto,UUID uuid);
}
