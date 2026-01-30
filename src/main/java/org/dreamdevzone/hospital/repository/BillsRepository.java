package org.dreamdevzone.hospital.repository;

import org.dreamdevzone.hospital.model.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BillsRepository extends JpaRepository<Bill, UUID> {
}
