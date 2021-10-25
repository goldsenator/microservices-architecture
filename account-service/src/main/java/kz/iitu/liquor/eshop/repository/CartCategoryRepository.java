package kz.iitu.liquor.eshop.repository;

import kz.iitu.liquor.eshop.categoty.CartCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartCategoryRepository extends JpaRepository<CartCategory, Long> {
    CartCategory getById(Long id);
}
