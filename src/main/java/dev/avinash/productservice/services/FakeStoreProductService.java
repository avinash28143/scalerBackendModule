package dev.avinash.productservice.services;

import dev.avinash.productservice.dtos.FakeStoreProductDto;
import dev.avinash.productservice.dtos.GenericProductDto;
import dev.avinash.productservice.exceptions.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String productRequestBaseUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    GenericProductDto convertFakeStoreProductDtoIntoGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto product = new GenericProductDto();

        product.setTitle(fakeStoreProductDto.getTitle());
        product.setId(fakeStoreProductDto.getId());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());

        return  product;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product){

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(productRequestBaseUrl, product,
                                                                        GenericProductDto.class);

        return response.getBody();
    }

    @Override
    public GenericProductDto deleteProduct(Long id){

        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        GenericProductDto product = convertFakeStoreProductDtoIntoGenericProductDto(fakeStoreProductDto);

        return product;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();

           ResponseEntity<FakeStoreProductDto[]> response =
                    restTemplate.getForEntity(productRequestBaseUrl, FakeStoreProductDto[].class);

          List<GenericProductDto> answer = new ArrayList<>();

         for (FakeStoreProductDto fakeStoreProductDto : response.getBody()){

             FakeStoreProductDto fakeStoreProductDto1 = fakeStoreProductDto;

             GenericProductDto product = convertFakeStoreProductDtoIntoGenericProductDto(fakeStoreProductDto);

             answer.add(product);
         }
        return answer;
    }


    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =
                        restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        if(fakeStoreProductDto == null){
            throw new NotFoundException("Product with id : " + id + " does not exist");
        }

        GenericProductDto product = convertFakeStoreProductDtoIntoGenericProductDto(fakeStoreProductDto);
        return  product;
    }
}
