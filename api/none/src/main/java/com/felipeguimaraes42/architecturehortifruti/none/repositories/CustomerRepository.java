package com.felipeguimaraes42.architecturehortifruti.none.repositories;

import com.felipeguimaraes42.architecturehortifruti.none.domains.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  Optional<Customer> findByUsername(final String username);
}
