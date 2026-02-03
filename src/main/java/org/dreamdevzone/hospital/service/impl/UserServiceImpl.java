package org.dreamdevzone.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.exception.ResourceNotFoundException;
import org.dreamdevzone.hospital.mapper.UserMapper;
import org.dreamdevzone.hospital.model.dto.UserDto;
import org.dreamdevzone.hospital.repository.UserRepository;
import org.dreamdevzone.hospital.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserDto addUser(UserDto userDto) {
        return mapper.toDto(repository.save(mapper.toEntity(userDto)));
    }

    @Override
    public UserDto updateUser(UserDto userDto, UUID uuid) {
        if (!repository.existsById(uuid)) throw new ResourceNotFoundException("User not found!", HttpStatus.NOT_FOUND);
        userDto.setId(uuid);
        return mapper.toDto(repository.save(mapper.toEntity(userDto)));
    }

    @Override
    public UserDto getUser(UUID uuid) {
        return mapper.toDto(repository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("User not found!", HttpStatus.NOT_FOUND)));

    }

    @Override
    public void deleteUser(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public Page<@NotNull UserDto> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }


}
