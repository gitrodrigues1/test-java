package br.com.blz.testjava.application.dtos;

public class CreateProductResponseDto {
    
    private long sku;
    private String name;
    private InventoryDto inventory;
    private boolean isMarketable;

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

    public boolean isMarketable() {
        return isMarketable;
    }

    public void setMarketable(boolean isMarketable) {
        this.isMarketable = isMarketable;
    }

    public InventoryDto getInventory() {
        return inventory;
    }

    public void setInventory(InventoryDto inventory) {
        this.inventory = inventory;
    }

    

}
