package dev.avinash.productservice.services;

import dev.avinash.productservice.dtos.GenericProductDto;
import dev.avinash.productservice.models.Product;
import org.springframework.stereotype.Service;


@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }
}
