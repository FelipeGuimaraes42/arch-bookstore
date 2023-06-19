package com.felipeguimaraes42.archbookstore.clean.usecases.models.customer;

public class CustomerRequestModel {
  private String username;
  private String password;

  public CustomerRequestModel() {}

  public CustomerRequestModel(final String username, final String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }
}
