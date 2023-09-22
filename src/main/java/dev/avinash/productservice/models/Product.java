package dev.avinash.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
//@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel {

    private String title;
    private String description;
    private String image;
    @ManyToOne
    private Category category;
    private double price;



}
