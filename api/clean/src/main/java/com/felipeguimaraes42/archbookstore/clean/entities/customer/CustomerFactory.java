package com.felipeguimaraes42.archbookstore.clean.entities.customer;

public interface CustomerFactory {
  Customer create(final String username, final String password);
}
