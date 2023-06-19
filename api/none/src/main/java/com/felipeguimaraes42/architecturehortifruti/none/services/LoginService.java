package com.felipeguimaraes42.architecturehortifruti.none.services;

import com.felipeguimaraes42.architecturehortifruti.none.domains.Customer;
import com.felipeguimaraes42.architecturehortifruti.none.repositories.CustomerRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  private final CustomerRepository customerRepository;

  public LoginService(final CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer execute(final Customer requestCustomer) {
    Optional<Customer> savedCustomer = getCustomer(requestCustomer.getUsername());
    if (savedCustomer.isPresent()) {
      final Customer validCustomer = savedCustomer.get();

      if (requestCustomer.getPassword().equals(validCustomer.getPassword())) {
        return validCustomer;
      }
    }

    return null;
  }

  public Optional<Customer> getCustomer(final String username) {
    return customerRepository.findByUsername(username);
  }
}
