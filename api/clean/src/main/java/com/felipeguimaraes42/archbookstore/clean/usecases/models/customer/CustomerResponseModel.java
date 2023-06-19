package com.felipeguimaraes42.archbookstore.clean.usecases.models.customer;

public class CustomerResponseModel {
  private String username;

  public CustomerResponseModel() {}

  public CustomerResponseModel(final String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }
}
