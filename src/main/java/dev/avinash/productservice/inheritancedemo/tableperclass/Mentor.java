package dev.avinash.productservice.inheritancedemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_Mentor")
public class Mentor extends User {
    private double averageRating;
}
