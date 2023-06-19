package com.felipeguimaraes42.architecturehortifruti.clean.adapters.formatters;

import com.felipeguimaraes42.architecturehortifruti.clean.usecases.models.customer.CustomerResponseModel;
import com.felipeguimaraes42.architecturehortifruti.clean.usecases.presenters.CustomerPresenter;

public class CustomerResponseFormatter implements CustomerPresenter {

  @Override
  public CustomerResponseModel prepareSuccessView(final CustomerResponseModel customer) {
    return customer;
  }

  @Override
  public CustomerResponseModel prepareFailView(final String error) {
    return null;
  }
}
