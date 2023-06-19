package com.felipeguimaraes42.archbookstore.clean.usecases.boundaries;

import com.felipeguimaraes42.archbookstore.clean.usecases.models.customer.CustomerRequestModel;
import com.felipeguimaraes42.archbookstore.clean.usecases.models.customer.CustomerResponseModel;

public interface CustomerLoginBoundary {
  CustomerResponseModel login(final CustomerRequestModel customer);
}
