package dev.avinash.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "categories")
@NoArgsConstructor
@Getter
@Setter
public class Category extends BaseModel{

    private String name;

    @OneToMany(fetch = jakarta.persistence.FetchType.EAGER, mappedBy = "category")
    private List<Product> products = new ArrayList<>();


}
