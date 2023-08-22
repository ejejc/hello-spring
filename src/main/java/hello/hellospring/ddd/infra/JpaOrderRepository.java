package hello.hellospring.ddd.infra;

import hello.hellospring.ddd.domain.Order;
import hello.hellospring.ddd.domain.OrderNo;
import hello.hellospring.ddd.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;

public class JpaOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<Order> findById(OrderNo id) {
        return em.find(Order.class, id);
    }

    @Override
    public void save(Order order) {
        em.persist(order);
    }
}
