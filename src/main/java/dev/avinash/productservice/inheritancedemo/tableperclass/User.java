package dev.avinash.productservice.inheritancedemo.tableperclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@DiscriminatorValue(value = "0")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private  String email;
}
