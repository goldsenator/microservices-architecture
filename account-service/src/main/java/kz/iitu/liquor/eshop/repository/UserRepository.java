package kz.iitu.liquor.eshop.repository;

import kz.iitu.liquor.eshop.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findById(Long id);
}
