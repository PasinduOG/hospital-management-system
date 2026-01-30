package org.dreamdevzone.hospital.mapper;

import org.dreamdevzone.hospital.model.dto.BillDto;
import org.dreamdevzone.hospital.model.entity.Bill;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface BillMapper {
    Bill toEntity(BillDto billDto);
    BillDto toDto(Bill bill);
    List<BillDto> toDtos(List<Bill> bills);
}
