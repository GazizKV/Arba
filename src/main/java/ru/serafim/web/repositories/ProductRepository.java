package ru.serafim.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.serafim.web.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
