package com.felipeguimaraes42.architecturehortifruti.clean.adapters.repositories.customer;

import com.felipeguimaraes42.architecturehortifruti.clean.adapters.mappers.CustomerDataMapper;
import com.felipeguimaraes42.architecturehortifruti.clean.usecases.gateways.CustomerGateway;
import com.felipeguimaraes42.architecturehortifruti.clean.usecases.models.customer.CustomerGatewayRequestModel;
import java.util.Optional;

public class CustomerRepository implements CustomerGateway {
  private final JpaCustomerRepository repository;

  public CustomerRepository(final JpaCustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<CustomerDataMapper> findByUsername(final String username) {
    return repository.findByUsername(username);
  }

  @Override
  public void save(final CustomerGatewayRequestModel customer) {
    final CustomerDataMapper data =
        CustomerDataMapper.builder()
            .username(customer.getUsername())
            .password(customer.getPassword())
            .build();
    repository.save(data);
  }
}
