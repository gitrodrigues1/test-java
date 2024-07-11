package br.com.blz.testjava.application.dtos;

public class UpdateProductRequestDto {
    
    private long sku;
    private String name;
    private InventoryDto inventory;

    
    public long getSku() {
        return sku;
    }

    public void setSku(long sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public InventoryDto getInventory() {
        return inventory;
    }

    public void setInventory(InventoryDto inventory) {
        this.inventory = inventory;
    }  
}
