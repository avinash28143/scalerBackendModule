package dev.avinash.productservice.inheritancedemo.singletable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_Mentor")
public class Mentor extends User {
    private double averageRating;
}
