package lt.codeacademy.rest.controller.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.math.BigDecimal;
import java.util.List;

import lt.codeacademy.rest.entities.Category;
import lt.codeacademy.rest.entities.Product;
import lt.codeacademy.rest.services.CategoryService;
import lt.codeacademy.rest.services.ProductsService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController("ProductsController")
@RequestMapping("/products")
@CrossOrigin("http://localhost:3000")
// Swagger
@Api(value = "Products controller")
public class ProductsController {

    private final ProductsService productsService;
    private final CategoryService categoryService;

    public ProductsController(ProductsService productsService, CategoryService categoryService) {
        this.productsService = productsService;
        this.categoryService = categoryService;
    }
//Swagger
    @ApiResponses({
            @ApiResponse(code = 500, message = "Somethings wrong")
    })
    @GetMapping("/list")
    @ApiOperation(value = "Get All Products")
    public List<Product> getProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping("/paginated")
    public Page<Product> getProductsPaginated(
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize") int pageSize
    ) {
        return productsService.getProductsPaginated(pageNumber, pageSize);
    }

    //Swagger
    @ApiOperation(value = "Returns product by id")
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productsService.getProductById(id);
    }

    //Swagger
    @ApiOperation(value = "Creates product")
    @PostMapping("/private/product")
    @PreAuthorize("hasAnyRole('ADMIN', 'CUSTOMER')")
    public Product createProduct(
            @RequestParam(name = "file", required = false) MultipartFile file,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "price") String price
//            @RequestParam(name = "category") String category
    ) {
        BigDecimal bdPrice = new BigDecimal(price);

        Product product = Product.builder()
                .title(title)
                .description(description)
                .price(bdPrice)
//                .category(category)
                .build();

        return productsService.createProduct(product, file);
    }

    @GetMapping("/fail")
    public Product getFailure() {
        throw new RuntimeException("This is an error");
    }


    @DeleteMapping("/private/{id}/delete")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Delete product by id")
    public String deleteItem(@PathVariable Long id){
        productsService.deleteProduct(id);

        return "Item with id - " + id + " was successfully deleted!";
    }

    @PutMapping("/private/{id}/update/product")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Update product")
    public Product updateProduct(
            @RequestParam(name = "id") String id,
            @RequestParam(name = "file", required = false) MultipartFile file,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "price") String price
    ) {

        Long convertedId = Long.valueOf(id);
        BigDecimal bdPrice = new BigDecimal(price);

        Product product = Product.builder()
                .id(convertedId)
                .title(title)
                .description(description)
                .price(bdPrice)
                .build();

        return productsService.createProduct(product, file);
    }

    @GetMapping("/private/{id}/update/product")
    public Product updateProduct(@PathVariable Long id) {
        return productsService.getProductById(id);
    }

    @GetMapping("/list/category/{id}")
    @ApiOperation(value = "Get All Categories by id")
    public List<Product> getProductsByCategoryId(@PathVariable Long id) {
        return productsService.getProductsByCategoryId(id);
    }

    @GetMapping("/list/category")
    @ApiOperation(value = "Get All Categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategory();
    }
}