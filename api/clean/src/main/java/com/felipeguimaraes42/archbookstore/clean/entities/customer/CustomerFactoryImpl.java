package com.felipeguimaraes42.archbookstore.clean.entities.customer;

public class CustomerFactoryImpl implements CustomerFactory {

  @Override
  public Customer create(final String username, final String password) {
    return new CustomerImpl(username, password);
  }
}
