package com.felipeguimaraes42.architecturehortifruti.clean.entities.customer;

public interface Customer {
  String getUsername();

  String getPassword();

  boolean isPasswordValid();
}
