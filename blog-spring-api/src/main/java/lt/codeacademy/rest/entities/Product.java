package lt.codeacademy.rest.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@Entity
@Table(name = "Products")
@ApiModel(value = "Product", description = "A product in this eshop")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    @ApiModelProperty(hidden = true)
    private Long id;

    @Column(name = "title")
    @Length(min = 2, max = 20, message="Title should be from 2 to 20 characters long")
    @NotBlank(message = "Title cannot be blank")
    @ApiModelProperty(notes = "Title of the Product")
    private String title;

    @Column(name = "description")
    @Length(min = 2, max = 100, message="Description should be from 2 to 100 characters long")
    @NotBlank(message = "Description cannot be blank")
    @ApiModelProperty(notes = "Description of the Product")
    private String description;

    @Column(name = "price")
    @DecimalMin("0.01")
    @DecimalMax("10000.01")
    @NotNull
    @ApiModelProperty(notes = "Price of the Product")
    private BigDecimal price;

    @ApiModelProperty(notes = "File Name of the Product")
    @Column(name = "file_name")
    private String fileName;

    @ApiModelProperty(notes = "Category of the Product")
    @OneToOne(fetch = FetchType.EAGER)
    private Category category;

    @Tolerate
    public Product(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
