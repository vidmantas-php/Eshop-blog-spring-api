package lt.codeacademy.rest.entities;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Builder
@Entity
@Table(name = "Orders")
@ApiModel(value = "Order", description = "Order in this eshop")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product cannot be null")
    @ApiModelProperty(notes = "Product of the order")
    @OneToOne(cascade = CascadeType.PERSIST)
    private Product product;

    @NotNull(message = "Quantity cannot be null")
    @ApiModelProperty(notes = "Quantity of the product in order")
    @Column(name = "quantity")
    private Long quantity;

    @NotNull(message = "Customer cannot be null")
    @ApiModelProperty(notes = "Customer of order")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @CreationTimestamp
    @ColumnDefault("current_timestamp")
    @ApiModelProperty(notes = "Date when order was created")
    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Tolerate
    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
