package dev.avinash.productservice.Repositories;

import dev.avinash.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
