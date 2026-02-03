package org.dreamdevzone.hospital.service;

import jakarta.validation.constraints.NotNull;
import org.dreamdevzone.hospital.model.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserService {
    UserDto addUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, UUID uuid);
    UserDto getUser(UUID uuid);
    void deleteUser(UUID uuid);
    Page<@NotNull UserDto> getAll(Pageable pageable);
}
