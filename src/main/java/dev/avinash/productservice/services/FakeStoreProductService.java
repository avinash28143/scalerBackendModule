package dev.avinash.productservice.services;

import dev.avinash.productservice.dtos.FakeStoreProductDto;
import dev.avinash.productservice.dtos.GenericProductDto;
import dev.avinash.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestUrl = "https://fakestoreapi.com/products";
    private String deleteProductByIdUrl = "https://fakestoreapi.com/products/{id}";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product){

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(createProductRequestUrl, product,
                                                                        GenericProductDto.class);

        return response.getBody();
    }

    @Override
    public GenericProductDto deleteProduct(Long id){

        String url = deleteProductByIdUrl + "/products/" + id;

        RestTemplate restTemplate = restTemplateBuilder.build();

      //  ResponseEntity<GenericProductDto> response = restTemplate.delete(deleteProductByIdUrl, id);

        GenericProductDto product = new GenericProductDto();
        return product;
    }


    @Override
    public GenericProductDto getProductById(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =
                        restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        GenericProductDto product = new GenericProductDto();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        //response.getStatusCode();
        return  product;
    }
}
