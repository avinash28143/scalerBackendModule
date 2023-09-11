package dev.avinash.productservice.controller;

import dev.avinash.productservice.dtos.GenericProductDto;
import dev.avinash.productservice.models.Product;
import dev.avinash.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
//@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getAllProducts() {
      return "All Products";
    }

    //Retrieve a particular product
    @GetMapping("/products/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
       // Product ps = productService.getProductById(id);
        return productService.getProductById(id);
    }

    //Delete a product
    @DeleteMapping("/products/{id}")
    public GenericProductDto deleteProductById() {

        return null;
    }

    //Create a new product
    @PostMapping("/products")
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        return productService.createProduct(product);
    }

    @PutMapping("/products/{id}")
    public void updateProductById() {

    }
}
