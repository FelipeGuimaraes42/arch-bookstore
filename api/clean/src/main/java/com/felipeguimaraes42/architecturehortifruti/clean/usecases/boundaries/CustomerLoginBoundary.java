package com.felipeguimaraes42.architecturehortifruti.clean.usecases.boundaries;

import com.felipeguimaraes42.architecturehortifruti.clean.usecases.models.customer.CustomerRequestModel;
import com.felipeguimaraes42.architecturehortifruti.clean.usecases.models.customer.CustomerResponseModel;

public interface CustomerLoginBoundary {
  CustomerResponseModel login(final CustomerRequestModel customer);
}
