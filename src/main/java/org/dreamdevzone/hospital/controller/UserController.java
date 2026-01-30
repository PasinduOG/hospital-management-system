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
}
