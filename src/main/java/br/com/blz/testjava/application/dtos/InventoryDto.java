package br.com.blz.testjava.application.dtos;

import java.util.List;

public class InventoryDto {
    
    private Integer quantity;
    private List<WarehouseDto> warehouses;
    
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public List<WarehouseDto> getWarehouses() {
        return warehouses;
    }
    public void setWarehouses(List<WarehouseDto> warehouses) {
        this.warehouses = warehouses;
    }

    
}
