package br.com.blz.testjava.application.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.blz.testjava.application.dtos.CreateProductRequestDto;
import br.com.blz.testjava.application.dtos.CreateProductResponseDto;
import br.com.blz.testjava.application.dtos.GetProductResponseDto;
import br.com.blz.testjava.application.dtos.UpdateProductRequestDto;
import br.com.blz.testjava.application.mapper.ProductMapper;
import br.com.blz.testjava.core.model.Product;
import br.com.blz.testjava.core.ports.IProductPort;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final IProductPort productPort;

    public ProductController(IProductPort productPort) {
        this.productPort = productPort;
    }

    @PostMapping
    public ResponseEntity<CreateProductResponseDto> create(@RequestBody CreateProductRequestDto dto) {
        
        Product newProduct = productPort.create(ProductMapper.toModel(dto));        
        return new ResponseEntity<>(ProductMapper.toCreateDto(newProduct) , HttpStatus.CREATED);
    }

    @GetMapping("/{sku}")
    public ResponseEntity<GetProductResponseDto> getProductBySku(@PathVariable long sku) {

        Product foundProduct = productPort.getBySku(sku);
        GetProductResponseDto dto = ProductMapper.toDto(foundProduct);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{sku}")
    public ResponseEntity<GetProductResponseDto> updateProduct(@PathVariable long sku, @RequestBody UpdateProductRequestDto request) {

        Product updatedProduct = productPort.edit(sku, ProductMapper.toModel(request));
        GetProductResponseDto dto = ProductMapper.toDto(updatedProduct);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{sku}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long sku) {
        productPort.delete(sku);
        return ResponseEntity.accepted().build();
    }
}
