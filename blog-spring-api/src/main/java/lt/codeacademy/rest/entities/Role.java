package lt.codeacademy.rest.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Roles")
@ApiModel(value = "Role", description = "Role for the user in this eshop")
public class Role {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role")
    @ApiModelProperty(notes = "Role for the user")
    private String role;
}
