package org.dreamdevzone.hospital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.RoomDto;
import org.dreamdevzone.hospital.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {
    private final RoomService service;
    @PostMapping
    public void addRoom(@Valid @RequestBody RoomDto dto){
        service.addRoom(dto);
    }
    @GetMapping("/{id}")
    public RoomDto getRoom(@PathVariable UUID id){
        return service.getRoom(id);
    }
    @GetMapping
    public List<RoomDto> findAll(){
        return service.getAllRooms();
    }
    @DeleteMapping
    public void deleteRoom(@Valid @RequestBody UUID uuid){
        service.deleteRoom(uuid);
    }
    @PutMapping
    public RoomDto updateRoom(@Valid @RequestBody RoomDto dto){
        return service.getRoom(dto.getId());
    }
}
