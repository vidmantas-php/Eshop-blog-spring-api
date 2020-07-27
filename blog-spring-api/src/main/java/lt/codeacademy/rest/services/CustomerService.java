package lt.codeacademy.rest.services;

import lt.codeacademy.rest.entities.Customer;
import lt.codeacademy.rest.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    CustomerRepository customerRepository;
    UserDetailsServiceImpl userDetailsService;

    public CustomerService(
            CustomerRepository customerRepository,
            UserDetailsServiceImpl userDetailsService
    ) {
        this.customerRepository = customerRepository;
        this.userDetailsService = userDetailsService;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerByUser(Long id) {
        Customer customer = new Customer();
            for (Customer c: customerRepository.findAll()) {
                if(c.getUser().getId().equals(id)) {
                    customer = c;
                }
            }
            return customer;
        }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
