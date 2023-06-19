package com.felipeguimaraes42.architecturehortifruti.mvc.controller.mappers;

import com.felipeguimaraes42.architecturehortifruti.mvc.controller.entities.CustomerEntity;
import com.felipeguimaraes42.architecturehortifruti.mvc.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  Customer toCustomer(final CustomerEntity customerEntity);

  CustomerEntity toCustomerEntity(final Customer customer);
}
