package com.felipeguimaraes42.archbookstore.clean.usecases.gateways;

import com.felipeguimaraes42.archbookstore.clean.adapters.mappers.CustomerDataMapper;
import com.felipeguimaraes42.archbookstore.clean.usecases.models.customer.CustomerGatewayRequestModel;
import java.util.Optional;

public interface CustomerGateway {
  Optional<CustomerDataMapper> findByUsername(final String username);

  void save(CustomerGatewayRequestModel customer);
}
