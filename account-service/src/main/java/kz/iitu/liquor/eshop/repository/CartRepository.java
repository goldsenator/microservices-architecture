package kz.iitu.liquor.eshop.repository;

import com.sun.istack.NotNull;
import kz.iitu.liquor.eshop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart getById(Long id);
}
