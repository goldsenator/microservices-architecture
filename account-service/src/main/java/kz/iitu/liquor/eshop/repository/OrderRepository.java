package kz.iitu.liquor.eshop.repository;

import kz.iitu.liquor.eshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order getById(Long id);
}
