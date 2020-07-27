package lt.codeacademy.rest.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lt.codeacademy.rest.entities.Product;
import lt.codeacademy.rest.repositories.ProductRepository;
import lt.codeacademy.rest.services.exceptions.ProductNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductsServiceTest {

    private ProductsService productsService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private FileStorageService fileStorageService;

    @Mock
    private CategoryService categoryService;

    @BeforeEach
    public void setUp() {
        productsService = new ProductsService(productRepository, fileStorageService, categoryService);
    }

    @Test
    public void shouldReturnProducts() {
        Product product = new Product();

        when(productRepository.findAll())
                .thenReturn(Arrays.asList(product));

        List<Product> allProducts = productsService.getAllProducts();
        Assertions.assertTrue(!allProducts.isEmpty());
        verify(productRepository).findAll();
    }

    @Test
    public void shouldReturnEmptyWhenNoProducts() {
        List<Product> allProducts = productsService.getAllProducts();
        Assertions.assertTrue(allProducts.isEmpty());
    }

    @Test
    public void shouldThrowExceptionWhenNoProduct() {
        Assertions.assertThrows(ProductNotFoundException.class, () -> productsService.getProductById(1L));
    }

    @Test
    public void shouldReturnProduct() {
        Product product = new Product();
        when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));

        Product result = productsService.getProductById(1L);

        Assertions.assertTrue(result != null);
    }


    // Parašyti testą, kuris: Jei duombazėje yra 5 įrašai,
    // tai gaunant visus, patikrina, kad gavo visus 5
    @Test
    public void shouldReturn5When5InDb() {
        Product product = new Product();

        when(productRepository.findAll())
                .thenReturn(Arrays.asList(product, product, product, product, product));

        List<Product> result = productsService.getAllProducts();
        Assertions.assertTrue(result.size() == 5);
    }
}