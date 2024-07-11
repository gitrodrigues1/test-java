package br.com.blz.testjava.core.adapter;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import br.com.blz.testjava.core.exceptions.BusinessLogicException;
import br.com.blz.testjava.core.model.Product;
import br.com.blz.testjava.core.model.Warehouse;
import br.com.blz.testjava.core.ports.IProductPort;
import br.com.blz.testjava.infrastructure.database.DatabaseAdapter;

@Service
public class ProductAdapter implements IProductPort {

    private DatabaseAdapter databaseAdapter;

    public ProductAdapter(DatabaseAdapter databaseAdapter) {
        this.databaseAdapter = databaseAdapter;
    }

    @Override
    public Product create(Product product) {

        if (existBySku(product.getSku()))
            throw new BusinessLogicException("Product already exists!");

        this.databaseAdapter.addProduct(product);
        product.getInventory().setQuantity(calculateInventoryQuantity(product.getInventory().getWarehouses()));
        product.setMarketable(handleIsMarketable(product.getInventory().getQuantity()));
        return product;        
    }

    @Override
    public Product edit(long sku, Product product) {
        Product p = this.databaseAdapter.editProduct(sku, product);

        if(Objects.isNull(p)) {
            throw new BusinessLogicException("Product not found!");
        }
        p.getInventory().setQuantity(calculateInventoryQuantity(p.getInventory().getWarehouses()));
        p.setMarketable(handleIsMarketable(p.getInventory().getQuantity()));
        return p;
    }

    @Override
    public Product getBySku(long sku) {
        Product p = this.databaseAdapter.getProduct(sku);

        if(Objects.isNull(p)) {
            throw new BusinessLogicException("Product not found!");
        }
        p.getInventory().setQuantity(calculateInventoryQuantity(p.getInventory().getWarehouses()));
        p.setMarketable(handleIsMarketable(p.getInventory().getQuantity()));
        return p;
    }

    @Override
    public void delete(long sku) {
        this.databaseAdapter.removeProduct(sku);
    }

    public boolean existBySku(long sku) {
        Product p = this.databaseAdapter.getProduct(sku);
        if(Objects.isNull(p)) {
            return false;
        }
        return true;
    }
    

    public Integer calculateInventoryQuantity(List<Warehouse> warehouse) {
        AtomicInteger count = new AtomicInteger(0);
        warehouse.forEach(w -> count.addAndGet(w.getQuantity()));
        return count.get();
    }

    public boolean handleIsMarketable(int inventoryQuantity) {
        if(inventoryQuantity > 0 )
            return true;
        return false;
    }

}
