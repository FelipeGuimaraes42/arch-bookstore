package com.felipeguimaraes42.archbookstore.clean.usecases.presenters;

import com.felipeguimaraes42.archbookstore.clean.usecases.models.customer.CustomerResponseModel;

public interface CustomerPresenter {
  CustomerResponseModel prepareSuccessView(final CustomerResponseModel customer);

  CustomerResponseModel prepareFailView(final String error);
}
