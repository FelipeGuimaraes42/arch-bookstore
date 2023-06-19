package com.felipeguimaraes42.archbookstore.clean.adapters.formatters;

import com.felipeguimaraes42.archbookstore.clean.usecases.models.customer.CustomerResponseModel;
import com.felipeguimaraes42.archbookstore.clean.usecases.presenters.CustomerPresenter;

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
