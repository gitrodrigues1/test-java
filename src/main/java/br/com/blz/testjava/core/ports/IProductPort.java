package br.com.blz.testjava.core.ports;

import br.com.blz.testjava.core.model.Product;

public interface IProductPort {

    public Product create(Product p);
    public Product edit(long sku, Product p);
    public Product getBySku(long sku);
    public void delete(long sku);
}
