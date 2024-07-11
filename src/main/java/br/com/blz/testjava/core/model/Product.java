package br.com.blz.testjava.core.model;

public class Product {

    private long sku;
    private String name;
    private Inventory inventory;
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
    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public boolean isMarketable() {
        return isMarketable;
    }
    public void setMarketable(boolean isMarketable) {
        this.isMarketable = isMarketable;
    }
    

    
    
}
