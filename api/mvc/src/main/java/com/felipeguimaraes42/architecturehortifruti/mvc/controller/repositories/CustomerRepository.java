package com.felipeguimaraes42.architecturehortifruti.mvc.controller.repositories;

import com.felipeguimaraes42.architecturehortifruti.mvc.controller.entities.CustomerEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
  Optional<CustomerEntity> findByUsername(final String username);
}
