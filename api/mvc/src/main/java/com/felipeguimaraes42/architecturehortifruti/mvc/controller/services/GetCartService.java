package com.felipeguimaraes42.architecturehortifruti.mvc.controller.services;

import static java.util.Objects.nonNull;

import com.felipeguimaraes42.architecturehortifruti.mvc.controller.dtos.ShoppingCartDTO;
import com.felipeguimaraes42.architecturehortifruti.mvc.controller.entities.CustomerEntity;
import com.felipeguimaraes42.architecturehortifruti.mvc.controller.mappers.CartMapper;
import com.felipeguimaraes42.architecturehortifruti.mvc.controller.repositories.CustomerRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class GetCartService {
  private final CustomerRepository customerRepository;

  public GetCartService(final CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public ShoppingCartDTO execute(final String username) {
    Optional<CustomerEntity> customer = customerRepository.findByUsername(username);
    if (nonNull(customer.orElse(null))) {
      ShoppingCartDTO cart = CartMapper.INSTANCE.toCartDTO(customer.get().getCart());
      if (nonNull(cart)) {
        return cart;
      }
    }
    return new ShoppingCartDTO();
  }
}
