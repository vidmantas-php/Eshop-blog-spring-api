package lt.codeacademy.rest.repositories;

import lt.codeacademy.rest.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
