package br.com.blz.testjava;

import static br.com.blz.testjava.common.ProductConstants.P1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        when(databaseAdapter.addProduct(P1)).thenReturn(P1);

        Product productTest = productAdapter.create(P1);

        assertThat(productTest).isEqualTo(P1);
    }

    @Test
    public void createProduct_WithInvalidData_ShouldReturnException() {
        when(databaseAdapter.addProduct(P1)).thenThrow(new BusinessLogicException("Sku Already Exists"));

        assertThrows(BusinessLogicException.class, () -> productAdapter.create(P1));
    }
    
}
