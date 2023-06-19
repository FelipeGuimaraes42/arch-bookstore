package com.felipeguimaraes42.architecturehortifruti.mvc.controller.services;

import com.felipeguimaraes42.architecturehortifruti.mvc.controller.entities.CustomerEntity;
import com.felipeguimaraes42.architecturehortifruti.mvc.controller.mappers.CustomerMapper;
import com.felipeguimaraes42.architecturehortifruti.mvc.controller.repositories.CustomerRepository;
import com.felipeguimaraes42.architecturehortifruti.mvc.model.Customer;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class GetCustomerService {
  private final CustomerRepository customerRepository;

  public GetCustomerService(final CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer execute(final Customer requestCustomer) {
    Optional<CustomerEntity> savedCustomer = getCustomer(requestCustomer.getUsername());
    if (savedCustomer.isPresent()) {
      final CustomerEntity validCustomer = savedCustomer.get();

      if (requestCustomer.getPassword().equals(validCustomer.getPassword())) {
        return CustomerMapper.INSTANCE.toCustomer(validCustomer);
      }
    }

    return null;
  }

  public Optional<CustomerEntity> getCustomer(final String username) {
    return customerRepository.findByUsername(username);
  }
}
