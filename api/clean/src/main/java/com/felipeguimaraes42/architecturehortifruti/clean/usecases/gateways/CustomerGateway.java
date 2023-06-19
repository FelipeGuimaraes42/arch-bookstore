package com.felipeguimaraes42.architecturehortifruti.clean.usecases.gateways;

import com.felipeguimaraes42.architecturehortifruti.clean.adapters.mappers.CustomerDataMapper;
import com.felipeguimaraes42.architecturehortifruti.clean.usecases.models.customer.CustomerGatewayRequestModel;
import java.util.Optional;

public interface CustomerGateway {
  Optional<CustomerDataMapper> findByUsername(final String username);

  void save(CustomerGatewayRequestModel customer);
}
