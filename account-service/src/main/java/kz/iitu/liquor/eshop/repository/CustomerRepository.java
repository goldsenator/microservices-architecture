package kz.iitu.liquor.eshop.repository;

import kz.iitu.liquor.eshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer getById(Long id);
}
