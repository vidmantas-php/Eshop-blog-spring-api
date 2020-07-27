package lt.codeacademy.rest.controller.controllers;

import java.util.List;

import io.swagger.annotations.ApiOperation;
import lt.codeacademy.rest.entities.Order;
import lt.codeacademy.rest.entities.User;
import lt.codeacademy.rest.services.CustomerService;
import lt.codeacademy.rest.services.OrderService;
import lt.codeacademy.rest.services.ProductsService;
import lt.codeacademy.rest.services.UserDetailsServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController("OrderController")
//@RequestMapping("/private/orders")
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;
    private ProductsService productsService;
    private CustomerService customerService;
    private UserDetailsServiceImpl userDetailsService;

    public OrderController(OrderService orderService,
                           ProductsService productsService,
                           CustomerService customerService,
                           UserDetailsServiceImpl userDetailsService
    ) {
        this.orderService = orderService;
        this.productsService = productsService;
        this.customerService = customerService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/get")
    @ApiOperation(value = "Get All Orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create new order")
    public Order buildOrder(@RequestParam(name = "productId") Long productId,
                            @RequestParam(name = "quantity") Long quantity,
                            @AuthenticationPrincipal User user) {

        Order order = Order.builder()
                .product(productsService.getProductById(productId))
                .quantity(quantity)
                .customer(customerService.getCustomerByUser(user.getId()))
                .build();

        return orderService.buildOrder(order);
    }

    @GetMapping("/orders")
    @ApiOperation(value = "Get All Orders By User")
    public List<Order> getAllOrdersByUser(@AuthenticationPrincipal User user) {
        return orderService.getOrdersByUser(user);
    }


}
