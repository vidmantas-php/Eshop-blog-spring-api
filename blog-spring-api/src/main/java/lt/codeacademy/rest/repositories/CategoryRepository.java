package lt.codeacademy.rest.repositories;

import lt.codeacademy.rest.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
