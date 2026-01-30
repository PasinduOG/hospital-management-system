package org.dreamdevzone.hospital.service;

import org.dreamdevzone.hospital.model.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDto addUser(UserDto userDto);
    void updateUser(UserDto userDto, UUID uuid);
    UserDto getUser(UUID uuid);
    void deleteUser(UUID uuid);
    List<UserDto> getAll();
}
