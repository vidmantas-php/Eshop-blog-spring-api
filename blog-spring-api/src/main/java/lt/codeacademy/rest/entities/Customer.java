package lt.codeacademy.rest.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@Entity
@Table(name = "Customers")
@ApiModel(value = "Customer", description = "Customer in this eshop")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "email")
    @Length(min = 2, max = 30, message="Email should be from 2 to 30 characters long")
    @NotBlank(message = "Email cannot be blank")
    @ApiModelProperty(notes = "Email of the Customer")
    private String email;

    @Column(name = "address")
    @Length(min = 2, max = 30, message="Address should be from 2 to 30 characters long")
    @NotBlank(message = "Address cannot be blank")
    @ApiModelProperty(notes = "Address of the Customer")
    private String address;

    @Column(name = "city")
    @Length(min = 2, max = 30, message="City should be from 2 to 30 characters long")
    @NotBlank(message = "City cannot be blank")
    @ApiModelProperty(notes = "City of the Customer")
    private String city;

    @NotNull(message = "User cannot be null")
    @ApiModelProperty(notes = "User of the Customer")
    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Tolerate
    public Customer() {
    }


}
