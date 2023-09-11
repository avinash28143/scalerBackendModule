package dev.avinash.productservice.models;

import lombok.Setter;

@Setter
public class Product extends BaseModel{

    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}
