package com.felipeguimaraes42.architecturehortifruti.clean.usecases.boundaries;

import com.felipeguimaraes42.architecturehortifruti.clean.usecases.models.customer.CustomerRequestModel;
import com.felipeguimaraes42.architecturehortifruti.clean.usecases.models.customer.CustomerResponseModel;

public interface CustomerRegisterBoundary {
  CustomerResponseModel register(final CustomerRequestModel customer);
}
