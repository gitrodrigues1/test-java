package br.com.blz.testjava.common;

import java.util.List;

import br.com.blz.testjava.core.enums.WareHouseTypeEnum;
import br.com.blz.testjava.core.model.Inventory;
import br.com.blz.testjava.core.model.Product;
import br.com.blz.testjava.core.model.Warehouse;

public class ProductConstants {
    public static final Product CREATE_PRODUCT = new Product(
        123456L,
        "Product 1", 
        new Inventory(List.of(new Warehouse("RJ", 5, WareHouseTypeEnum.PHYSICAL_STORE))));

    public static final Product UPDATE_PRODUCT = new Product(
        123456L,
        "Product 1 Updateted", 
        new Inventory(List.of(new Warehouse("RJ", 15, WareHouseTypeEnum.PHYSICAL_STORE))));

    public static final Product GET_PRODUCT = new Product(
        123456L,
        "Product 1", 
        new Inventory(
            List.of(
                new Warehouse("RJ", 3, WareHouseTypeEnum.PHYSICAL_STORE),
                new Warehouse("PE", 20, WareHouseTypeEnum.PHYSICAL_STORE)
            
        )));
}
