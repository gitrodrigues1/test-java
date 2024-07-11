package br.com.blz.testjava;

import static br.com.blz.testjava.common.ProductConstants.CREATE_PRODUCT;
import static br.com.blz.testjava.common.ProductConstants.GET_PRODUCT;
import static br.com.blz.testjava.common.ProductConstants.UPDATE_PRODUCT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import br.com.blz.testjava.core.adapter.ProductAdapter;
import br.com.blz.testjava.core.exceptions.BusinessLogicException;
import br.com.blz.testjava.core.model.Product;
import br.com.blz.testjava.infrastructure.database.DatabaseAdapter;

@ExtendWith(MockitoExtension.class)
public class ProductAdapterTest {

    @InjectMocks
    private ProductAdapter productAdapter;

    @Mock
    private DatabaseAdapter databaseAdapter;

    @Test
    public void createProduct_WithValidData_ShoulReturnProduct() {
        //AAA Arange Act Assert
        when(databaseAdapter.addProduct(CREATE_PRODUCT)).thenReturn(CREATE_PRODUCT);

        Product productTest = productAdapter.create(CREATE_PRODUCT);

        assertThat(productTest).isEqualTo(CREATE_PRODUCT);
    }

    @Test
    public void createProduct_WithInvalidData_ShouldReturnException() {
        when(databaseAdapter.addProduct(CREATE_PRODUCT)).thenThrow(new BusinessLogicException("Sku Already Exists"));

        assertThrows(BusinessLogicException.class, () -> productAdapter.create(CREATE_PRODUCT));
    }

    @Test
    public void updateProduct_WithValidDate_ShouldReturnProduct() {
        when(databaseAdapter.editProduct(UPDATE_PRODUCT.getSku(), UPDATE_PRODUCT)).thenReturn(UPDATE_PRODUCT);

        Product productTest = productAdapter.edit(123456, UPDATE_PRODUCT);

        assertThat(productTest).isEqualTo(UPDATE_PRODUCT);  
    }

    @Test
    public void updateProduct_WithValidDate_ShouldReturnException() {
        when(databaseAdapter.editProduct(CREATE_PRODUCT.getSku(), CREATE_PRODUCT)).thenThrow(new BusinessLogicException("Product Not Found!"));

        assertThrows(BusinessLogicException.class, () -> productAdapter.edit(123456, CREATE_PRODUCT));
    }

    @Test
    public void getProduct_WithValidData_ShouldReturnProduct() {
        when(databaseAdapter.getProduct(GET_PRODUCT.getSku())).thenReturn(GET_PRODUCT);

        Product productTest = productAdapter.getBySku(GET_PRODUCT.getSku());

        assertThat(productTest).isEqualTo(GET_PRODUCT);
    }

    @Test
    public void getProduct_WithInvalidData_ShouldReturnException() {
        when(databaseAdapter.getProduct(GET_PRODUCT.getSku())).thenThrow(new BusinessLogicException("Product Not Found!"));

        assertThrows(BusinessLogicException.class, () -> productAdapter.getBySku(GET_PRODUCT.getSku()));
    }

    @Test
    public void deleteProduct_WithValidData_ShouldNotReturnAnything() {
        doNothing().when(databaseAdapter).removeProduct(GET_PRODUCT.getSku());

        productAdapter.delete(GET_PRODUCT.getSku());

        verify(databaseAdapter, times(1)).removeProduct(GET_PRODUCT.getSku());
    }
    
}
