package dev.avinash.productservice.services;

import dev.avinash.productservice.dtos.GenericProductDto;
import dev.avinash.productservice.exceptions.NotFoundException;
import dev.avinash.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fakeStoreProductService")
public interface ProductService {

    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id) throws NotFoundException;

     List<GenericProductDto> getAllProducts();

     GenericProductDto deleteProduct(Long id);
}
