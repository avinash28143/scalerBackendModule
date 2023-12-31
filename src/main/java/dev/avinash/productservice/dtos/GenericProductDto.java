package dev.avinash.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenericProductDto {

    private Long id;
    private double price;
    private String title;
    private String category;
    private String description;
    private String image;
}
