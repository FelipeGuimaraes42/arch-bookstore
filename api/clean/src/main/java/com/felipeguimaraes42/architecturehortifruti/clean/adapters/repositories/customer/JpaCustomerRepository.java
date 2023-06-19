package com.felipeguimaraes42.architecturehortifruti.clean.adapters.repositories.customer;

import com.felipeguimaraes42.architecturehortifruti.clean.adapters.mappers.CustomerDataMapper;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCustomerRepository extends JpaRepository<CustomerDataMapper, Long> {
  Optional<CustomerDataMapper> findByUsername(final String username);
}
