package hello.hellospring.ddd.repository;

import hello.hellospring.ddd.domain.Order;
import hello.hellospring.ddd.domain.OrderNo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, OrderNo> {
    Optional<Order> findById(OrderNo id);
    void save(Order order);
}
