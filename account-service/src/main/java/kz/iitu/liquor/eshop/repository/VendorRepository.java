package kz.iitu.liquor.eshop.repository;

import kz.iitu.liquor.eshop.model.LTD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<LTD, Long> {
    Optional<LTD> findById(Long id);
}
