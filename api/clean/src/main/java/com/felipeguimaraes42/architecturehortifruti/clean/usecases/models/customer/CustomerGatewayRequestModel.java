package com.felipeguimaraes42.architecturehortifruti.clean.usecases.models.customer;

public class CustomerGatewayRequestModel {
  private String username;
  private String password;

  public CustomerGatewayRequestModel() {}

  public CustomerGatewayRequestModel(final String username, final String password) {
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
