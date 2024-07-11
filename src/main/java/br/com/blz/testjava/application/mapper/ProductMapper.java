package br.com.blz.testjava.application.mapper;

import br.com.blz.testjava.application.dtos.CreateProductRequestDto;
import br.com.blz.testjava.application.dtos.CreateProductResponseDto;
import br.com.blz.testjava.application.dtos.GetProductResponseDto;
import br.com.blz.testjava.application.dtos.UpdateProductRequestDto;
import br.com.blz.testjava.core.model.Product;

public class ProductMapper {

    public static Product toModel(CreateProductRequestDto dto) {
        Product product = new Product();
        product.setSku(dto.getSku());
        product.setName(dto.getName());
        product.setInventory(InventoryMapper.toModel(dto.getInventory()));
        return product;
    }

    public static Product toModel(UpdateProductRequestDto dto) {
        Product product = new Product();
        product.setSku(dto.getSku());
        product.setName(dto.getName());
        product.setInventory(InventoryMapper.toModel(dto.getInventory()));
        return product;
    }

    public static CreateProductResponseDto toCreateDto(Product model) {
        CreateProductResponseDto dto = new CreateProductResponseDto();
        dto.setSku(model.getSku());
        dto.setName(model.getName());
        dto.setInventory(InventoryMapper.toDto(model.getInventory()));
        dto.setMarketable(model.isMarketable());
        return dto;
    }

    public static GetProductResponseDto toDto(Product model) {
        GetProductResponseDto dto = new GetProductResponseDto();
        dto.setSku(model.getSku());
        dto.setName(model.getName());
        dto.setInventory(InventoryMapper.toDto(model.getInventory()));
        dto.setMarketable(model.isMarketable());
        return dto;
    }

}
