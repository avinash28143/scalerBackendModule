package dev.avinash.productservice.thirdpartyclients.productservice.fakestore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {

    private Long id;
    private double price;
    private String title;
    private String category;
    private String description;
    private String image;
}
