package kz.iitu.liquor.eshop.repository;

import kz.iitu.liquor.eshop.model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
    CartProduct getById(Long id);
}
