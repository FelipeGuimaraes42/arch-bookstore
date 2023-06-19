package com.felipeguimaraes42.architecturehortifruti.clean.usecases.presenters;

import com.felipeguimaraes42.architecturehortifruti.clean.usecases.models.customer.CustomerResponseModel;

public interface CustomerPresenter {
  CustomerResponseModel prepareSuccessView(final CustomerResponseModel customer);

  CustomerResponseModel prepareFailView(final String error);
}
