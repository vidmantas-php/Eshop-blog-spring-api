package lt.codeacademy.rest.repositories;

import lt.codeacademy.rest.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
