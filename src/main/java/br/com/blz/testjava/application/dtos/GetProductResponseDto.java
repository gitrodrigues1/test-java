package br.com.blz.testjava.application.dtos;

public class GetProductResponseDto {
    
    private long sku;
    private String name;
    private InventoryDto inventory;
    private Boolean isMarketable;
    
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
    public boolean isMarketable() {
        return isMarketable;
    }
    public void setMarketable(boolean isMarketable) {
        this.isMarketable = isMarketable;
    }

    
}
