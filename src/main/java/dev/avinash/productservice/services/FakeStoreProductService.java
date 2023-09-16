package dev.avinash.productservice.services;

import dev.avinash.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductDto;
import dev.avinash.productservice.dtos.GenericProductDto;
import dev.avinash.productservice.exceptions.NotFoundException;
import dev.avinash.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service("fakeStoreProductService")
@Primary
public class FakeStoreProductService implements ProductService {

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
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

        return convertFakeStoreProductDtoIntoGenericProductDto(fakeStoreProductServiceClient.createProduct(product));
    }

    @Override
    public GenericProductDto deleteProduct(Long id){

        return convertFakeStoreProductDtoIntoGenericProductDto(fakeStoreProductServiceClient.deleteProduct(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {

        List<GenericProductDto> genericProductDtos = new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductServiceClient.getAllProducts()){

            genericProductDtos.add(convertFakeStoreProductDtoIntoGenericProductDto(fakeStoreProductDto));
        }
        return genericProductDtos;
    }


    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {

        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductServiceClient.getProductById(id);

        if(fakeStoreProductDto == null){
            throw new NotFoundException("Product with id : " + id + " does not exist");
        }

        GenericProductDto product = convertFakeStoreProductDtoIntoGenericProductDto(fakeStoreProductDto);
        return  product;
    }
}
