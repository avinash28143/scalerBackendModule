package dev.avinash.productservice.inheritancedemo.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_Student")
@DiscriminatorValue(value = "1")
public class Student extends User {
    private double psp;
    private double attendance;
}
