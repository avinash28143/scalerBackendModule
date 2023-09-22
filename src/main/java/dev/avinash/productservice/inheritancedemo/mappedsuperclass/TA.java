package dev.avinash.productservice.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_TA")
public class TA extends User{
    private double averageRating;
}
