package dev.avinash.productservice.services;

import dev.avinash.productservice.dtos.GenericProductDto;
import dev.avinash.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("fakeStoreProductService")
public interface ProductService {

    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id);

     GenericProductDto deleteProduct(Long id);
}
