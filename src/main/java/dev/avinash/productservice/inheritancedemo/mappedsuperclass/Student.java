package dev.avinash.productservice.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_Student")
public class Student extends User{
    private double psp;
    private double attendance;
}
