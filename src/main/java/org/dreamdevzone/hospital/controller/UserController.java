package org.dreamdevzone.hospital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.UserDto;
import org.dreamdevzone.hospital.service.UserService;
import org.dreamdevzone.hospital.util.ApiResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    ResponseEntity<@NotNull ApiResponse<List<UserDto>>> getAll(){
        return ApiResponse.success("Users fetched!", service.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<UserDto>> get(@PathVariable UUID id){
        return ApiResponse.success("User fetched!", service.getUser(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<UserDto>> update(@RequestBody UserDto userDto, @PathVariable UUID id){
        return ApiResponse.success("User updated!", service.updateUser(userDto, id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<Void>> remove(@PathVariable UUID id){
        return ApiResponse.success("User removed");
    }
}
