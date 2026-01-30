package org.dreamdevzone.hospital.controller;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.hospital.model.dto.BillDto;
import org.dreamdevzone.hospital.service.impl.BillImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bill")
public class BillController {
    private final BillImpl service;
    @PostMapping
    public void addBill(@RequestBody BillDto dto){
        service.addBill(dto);
    }
    @GetMapping("/{id}")
    public BillDto getBill(@PathVariable UUID id){
        return service.getBill(id);
    }
    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable UUID id){
        service.deleteBill(id);
    }
    @GetMapping
    public List<BillDto> getAllBills(){
        return service.getAllBills();
    }
    @PutMapping("/{id}")
    public BillDto updateBill(@RequestBody BillDto dto,@PathVariable UUID id){
        return service.updateBill(dto,id);
    }
}
