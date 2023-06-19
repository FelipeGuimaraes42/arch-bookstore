package com.felipeguimaraes42.archbookstore.mvc.controller.services;

import com.felipeguimaraes42.archbookstore.mvc.controller.mappers.CustomerMapper;
import com.felipeguimaraes42.archbookstore.mvc.controller.repositories.CustomerRepository;
import com.felipeguimaraes42.archbookstore.mvc.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerService {
  private final CustomerRepository customerRepository;

  public RegisterCustomerService(final CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public void execute(final Customer customer) {
    customerRepository.save(CustomerMapper.INSTANCE.toCustomerEntity(customer));
  }
}
