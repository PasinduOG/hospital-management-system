package org.dreamdevzone.hospital.controller;

import io.github.pasinduog.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.RoomDto;
import org.dreamdevzone.hospital.service.RoomService;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/room")
@SuppressWarnings("unused")  // For hide unused warnings for endpoint methods @SuppressWarnings("unused")
public class RoomController {
    private final RoomService service;

    @PostMapping
    ResponseEntity<@NotNull ApiResponse<RoomDto>> addRoom(@Valid @RequestBody RoomDto dto){
        return ApiResponse.created("Room created!", service.addRoom(dto));
    }

    @GetMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<RoomDto>> getRoom(@PathVariable UUID id){
        return ApiResponse.success("Room fetched!", service.getRoom(id));
    }

    @GetMapping
    public ResponseEntity<@NotNull ApiResponse<Page<@NotNull RoomDto>>> getAllRooms(Pageable pageable) {
        String message = String.format("Fetched rooms! Page number: %d, Page size: %d", pageable.getPageNumber(), pageable.getPageSize());
        return ApiResponse.success(message, service.getAllRooms(pageable));
    }
    @DeleteMapping
    ResponseEntity<@NotNull ApiResponse<Void>> deleteRoom(@Valid @RequestBody UUID uuid){
        service.deleteRoom(uuid);
        return ApiResponse.success("Room removed!");
    }

    @PutMapping
    ResponseEntity<@NotNull ApiResponse<RoomDto>> updateRoom(@Valid @RequestBody RoomDto dto){
        return ApiResponse.success("Room updated!", service.getRoom(dto.getId()));
    }
}
