package com.felipeguimaraes42.architecturehortifruti.none.services;

import com.felipeguimaraes42.architecturehortifruti.none.domains.Customer;
import com.felipeguimaraes42.architecturehortifruti.none.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerService {

  private final CustomerRepository customerRepository;

  public RegisterCustomerService(final CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer execute(final Customer customer) {
    return customerRepository.save(customer);
  }
}
