package org.dreamdevzone.hospital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.UserDto;
import org.dreamdevzone.hospital.service.UserService;
import org.dreamdevzone.hospital.util.ApiResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    ResponseEntity<@NotNull ApiResponse<UserDto>> add(@Valid @RequestBody UserDto userDto){
        return ApiResponse.created("User created!", service.addUser(userDto));
    }

    @GetMapping
    public ResponseEntity<@NotNull ApiResponse<Page<@NotNull UserDto>>> getAllUsers(Pageable pageable) {
        String message = String.format("Fetched admissions! Page number: %d, Page size: %d", pageable.getPageNumber(), pageable.getPageSize());
        return ApiResponse.success(message, service.getAll(pageable));
    }

    @GetMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<UserDto>> get(@PathVariable UUID id){
        return ApiResponse.success("User fetched!", service.getUser(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<UserDto>> update(@Valid @RequestBody UserDto userDto, @PathVariable UUID id){
        return ApiResponse.success("User updated!", service.updateUser(userDto, id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<Void>> remove(@PathVariable UUID id){
        service.deleteUser(id);
        return ApiResponse.success("User removed");
    }
}
