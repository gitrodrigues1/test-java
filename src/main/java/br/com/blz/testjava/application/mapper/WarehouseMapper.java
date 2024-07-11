package br.com.blz.testjava.application.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.blz.testjava.application.dtos.WarehouseDto;
import br.com.blz.testjava.core.model.Warehouse;

public class WarehouseMapper {

    public static List<Warehouse> toModelList(List<WarehouseDto> dto) {
        List<Warehouse> model = new ArrayList<>();
        dto.forEach(m -> model.add(WarehouseMapper.toModel(m)));

        return model;
    }

    public static Warehouse toModel(WarehouseDto dto) {
        Warehouse w = new Warehouse();
        w.setLocality(dto.getLocality());
        w.setQuantity(dto.getQuantity());
        w.setType(dto.getType());

        return w;
    }
    
    public static List<WarehouseDto> toDtoList(List<Warehouse> model) {
        List<WarehouseDto> dto = new ArrayList<>();
        model.forEach(m -> dto.add(toDto(m)));

        return dto;
    }

    public static WarehouseDto toDto(Warehouse model) {
        WarehouseDto dto = new WarehouseDto();
        dto.setLocality(model.getLocality());
        dto.setQuantity(model.getQuantity());
        dto.setType(model.getType());

        return dto;
    }
}
