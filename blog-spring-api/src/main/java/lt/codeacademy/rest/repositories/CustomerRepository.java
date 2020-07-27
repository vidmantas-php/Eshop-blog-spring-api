package lt.codeacademy.rest.repositories;

import lt.codeacademy.rest.entities.Customer;
import lt.codeacademy.rest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
