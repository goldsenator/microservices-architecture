package kz.iitu.liquor.eshop.repository;

import kz.iitu.liquor.eshop.categoty.CartProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductCategoryRepository extends JpaRepository<CartProductCategory, Long> {
    CartProductCategory getById(Long id);
}
