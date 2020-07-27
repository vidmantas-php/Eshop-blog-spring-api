package lt.codeacademy.rest.controller.controllers;

import io.swagger.annotations.ApiOperation;
import lt.codeacademy.rest.entities.Customer;
import lt.codeacademy.rest.entities.User;
import lt.codeacademy.rest.services.CustomerService;
import lt.codeacademy.rest.services.UserDetailsServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController("CustomerController")
@RequestMapping("/customer")
@CrossOrigin("http://localhost:3000")
public class CustomerController {

    CustomerService customerService;
    UserDetailsServiceImpl userDetailsService;

    public CustomerController(CustomerService customerService,
                              UserDetailsServiceImpl userDetailsService) {
        this.customerService = customerService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/list")
    @ApiOperation(value = "Get All Customers")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/info")
    @ApiOperation(value = "Get customer by user id")
    public Customer getCustomerByUserId(@AuthenticationPrincipal User user) {
        return customerService.getCustomerByUser(user.getId());
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create new customer")
    public Customer createCustomer(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "address", required = false) String address,
            @RequestParam(name = "city") String city,
            @AuthenticationPrincipal User user
    ) {
        Customer customer = Customer.builder()
                .email(email)
                .address(address)
                .city(city)
                .user(user)
                .build();

        return customerService.createCustomer(customer);
    }
}
