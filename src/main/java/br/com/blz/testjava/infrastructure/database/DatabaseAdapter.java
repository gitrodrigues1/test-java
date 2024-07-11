package br.com.blz.testjava.infrastructure.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.blz.testjava.core.model.Product;

@Repository
public class DatabaseAdapter {

    List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        this.products.add(product);
        return product;
    }

    public Product editProduct(long sku, Product product) {
        
        for (Product p : products) {
            if(p.getSku() == sku) {
                p.setSku(product.getSku());
                p.setName(product.getName());
                p.setInventory(product.getInventory());
                return p;
            }
        }

        return null;
    }

    public Product getProduct(long sku) {
        for (Product p : products) {
            if(p.getSku() == sku) {
                return p;
            }
        }
        return null;
    }

    public void removeProduct(long sku) {
        for (Product p : products) {
            if(p.getSku() == sku) {
                this.products.remove(p);
                break;
            }
        }
    }
    
}
