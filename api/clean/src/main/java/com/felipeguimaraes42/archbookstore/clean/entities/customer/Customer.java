package com.felipeguimaraes42.archbookstore.clean.entities.customer;

public interface Customer {
  String getUsername();

  String getPassword();

  boolean isPasswordValid();
}
