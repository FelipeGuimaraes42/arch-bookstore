package com.felipeguimaraes42.architecturehortifruti.clean.entities.customer;

public interface CustomerFactory {
  Customer create(final String username, final String password);
}
