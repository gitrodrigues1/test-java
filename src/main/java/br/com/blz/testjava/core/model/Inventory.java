package br.com.blz.testjava.core.model;

import java.util.List;

public class Inventory {

    private int quantity;

    private List<Warehouse> warehouses;
    
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public List<Warehouse> getWarehouses() {
        return warehouses;
    }
    public void setWarehouses(List<Warehouse> warehouse) {
        this.warehouses = warehouse;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + quantity;
        result = prime * result + ((warehouses == null) ? 0 : warehouses.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Inventory other = (Inventory) obj;
        if (quantity != other.quantity)
            return false;
        if (warehouses == null) {
            if (other.warehouses != null)
                return false;
        } else if (!warehouses.equals(other.warehouses))
            return false;
        return true;
    }

    
    
}
