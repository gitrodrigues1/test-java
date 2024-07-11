package br.com.blz.testjava.application.mapper;

import br.com.blz.testjava.application.dtos.InventoryDto;
import br.com.blz.testjava.core.model.Inventory;

public class InventoryMapper {

    public static Inventory toModel(InventoryDto dto) {
        Inventory model = new Inventory();
        model.setWarehouses(WarehouseMapper.toModelList(dto.getWarehouses()));

        return model;
    }
    
    public static InventoryDto toDto(Inventory model) {
        InventoryDto dto = new InventoryDto();
        dto.setQuantity(model.getQuantity());
        dto.setWarehouses(WarehouseMapper.toDtoList(model.getWarehouses()));

        return dto;
    }
}
