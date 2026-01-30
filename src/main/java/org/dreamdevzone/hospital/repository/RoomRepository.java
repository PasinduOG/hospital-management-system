package org.dreamdevzone.hospital.repository;

import org.dreamdevzone.hospital.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, UUID> {
}
