package br.com.blz.testjava.common;

import java.util.List;

import br.com.blz.testjava.core.enums.WareHouseTypeEnum;
import br.com.blz.testjava.core.model.Inventory;
import br.com.blz.testjava.core.model.Product;
import br.com.blz.testjava.core.model.Warehouse;

public class ProductConstants {
    public static final Product P1 = new Product(
        123456L,
        "Product 1", 
        new Inventory(List.of(new Warehouse("RJ", 5, WareHouseTypeEnum.PHYSICAL_STORE))));
}
