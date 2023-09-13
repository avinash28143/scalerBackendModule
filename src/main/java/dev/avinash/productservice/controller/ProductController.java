package dev.avinash.productservice.controller;

import dev.avinash.productservice.dtos.ExceptionDto;
import dev.avinash.productservice.dtos.GenericProductDto;
import dev.avinash.productservice.exceptions.NotFoundException;
import dev.avinash.productservice.models.Product;
import dev.avinash.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
//@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<GenericProductDto> getAllProducts() {

      return productService.getAllProducts();
    }

    //Retrieve a particular product
    @GetMapping("/products/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
       // Product ps = productService.getProductById(id);
        return productService.getProductById(id);
    }


    //Delete a product
    @DeleteMapping("/products/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) {

        ResponseEntity<GenericProductDto> response = new ResponseEntity<>(
                productService.deleteProduct(id),
                HttpStatus.NOT_FOUND
        );
        return response;
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
