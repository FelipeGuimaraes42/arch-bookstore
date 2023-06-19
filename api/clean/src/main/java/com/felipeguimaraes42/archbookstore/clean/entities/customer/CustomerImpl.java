package com.felipeguimaraes42.archbookstore.clean.entities.customer;

public class CustomerImpl implements Customer {
  private String username;
  private String password;

  public CustomerImpl() {}

  public CustomerImpl(final String username, final String password) {
    this.username = username;
    this.password = password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public boolean isPasswordValid() {
    return this.password != null && this.password.length() > 5;
  }
}
