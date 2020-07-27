package lt.codeacademy.rest.services;

import lt.codeacademy.rest.entities.Category;
import lt.codeacademy.rest.repositories.CategoryRepository;
import lt.codeacademy.rest.services.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

        private final CategoryRepository categoryRepository;

        public CategoryService(
                CategoryRepository categoryRepository
        ) {
            this.categoryRepository = categoryRepository;
        }

        public List<Category> getAllCategory() {
            return categoryRepository.findAll();
        }

        public Category createCategory(Category category) {
            return categoryRepository.save(category);
        }

        public void deleteCategory(Long id) {
            categoryRepository.deleteById(id);
        }

        public Category getCategoryById(Long id) {
            return categoryRepository.findById(id)
                    .orElseThrow(() -> new ProductNotFoundException("Category with id: " + id + " was not found"));
        }
}
