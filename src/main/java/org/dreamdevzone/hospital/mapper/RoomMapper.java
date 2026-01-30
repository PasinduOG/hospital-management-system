package org.dreamdevzone.hospital.mapper;

import org.dreamdevzone.hospital.model.dto.RoomDto;
import org.dreamdevzone.hospital.model.entity.Room;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    RoomDto toDto(Room room);
    Room toEntity(RoomDto dto);
    List<RoomDto> toDtos(List<Room> rooms);
}
