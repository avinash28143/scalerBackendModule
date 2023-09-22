package dev.avinash.productservice.inheritancedemo.singletable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_TA")
public class TA extends User {
    private double averageRating;
}
