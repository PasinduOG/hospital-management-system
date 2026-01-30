package org.dreamdevzone.hospital.mapper;

import org.dreamdevzone.hospital.model.dto.UserDto;
import org.dreamdevzone.hospital.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
