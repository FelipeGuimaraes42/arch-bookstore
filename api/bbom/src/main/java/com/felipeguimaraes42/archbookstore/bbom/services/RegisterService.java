package com.felipeguimaraes42.archbookstore.bbom.services;

import com.felipeguimaraes42.archbookstore.bbom.domains.Customer;
import com.felipeguimaraes42.archbookstore.bbom.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

  private final CustomerRepository customerRepository;

  public RegisterService(final CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer execute(final Customer requestCustomer) {
    Customer customer;
    try {
      customer = customerRepository.save(requestCustomer);
    } catch (RuntimeException ex) {
      customer = null;
    }

    return customer;
  }
}
