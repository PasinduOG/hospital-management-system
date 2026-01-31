package org.dreamdevzone.hospital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.BillDto;
import org.dreamdevzone.hospital.service.BillService;
import org.dreamdevzone.hospital.util.ApiResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bill")
@SuppressWarnings("unused")  // For hide unused warnings for endpoint methods @SuppressWarnings("unused")
public class BillController {
    private final BillService service;

    @PostMapping
    ResponseEntity<@NotNull ApiResponse<BillDto>> addBill(@Valid @RequestBody BillDto dto){
        return ApiResponse.created("Bill created", service.addBill(dto));
    }

    @GetMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<BillDto>> getBill(@PathVariable UUID id){
        return ApiResponse.success("Bill fetched!", service.getBill(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<Void>> deleteBill(@PathVariable UUID id){
        service.deleteBill(id);
        return ApiResponse.success("Bill removed!");
    }

    @GetMapping
    ResponseEntity<@NotNull ApiResponse<Page<@NotNull BillDto>>> getAllBills(Pageable pageable){
        String message = String.format("Fetched bills page %d of size %d!", pageable.getPageNumber(), pageable.getPageSize());
        return ApiResponse.success(message, service.getAllBills(pageable));
    }

    @PutMapping("/{id}")
    ResponseEntity<@NotNull ApiResponse<BillDto>> updateBill(@Valid @RequestBody BillDto dto,@PathVariable UUID id){
        return ApiResponse.success("Bill updated!", service.updateBill(dto,id));
    }
}
