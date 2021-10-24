package kz.iitu.liquor.eshop.repository;

import kz.iitu.liquor.eshop.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    Optional<Service> findById(Long id);
}
