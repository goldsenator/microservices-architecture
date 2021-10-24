package kz.iitu.liquor.eshop.repository;

import kz.iitu.liquor.eshop.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    OrderDetail getById(Long id);
}
