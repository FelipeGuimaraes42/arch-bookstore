package com.felipeguimaraes42.archbookstore.clean.usecases.interactors;

import com.felipeguimaraes42.archbookstore.clean.adapters.mappers.CustomerDataMapper;
import com.felipeguimaraes42.archbookstore.clean.usecases.boundaries.CustomerLoginBoundary;
import com.felipeguimaraes42.archbookstore.clean.usecases.gateways.CustomerGateway;
import com.felipeguimaraes42.archbookstore.clean.usecases.models.customer.CustomerRequestModel;
import com.felipeguimaraes42.archbookstore.clean.usecases.models.customer.CustomerResponseModel;
import com.felipeguimaraes42.archbookstore.clean.usecases.presenters.CustomerPresenter;
import java.util.Optional;

public class CustomerLoginInteractor implements CustomerLoginBoundary {
  private final CustomerPresenter presenter;
  private final CustomerGateway gateway;

  public CustomerLoginInteractor(final CustomerPresenter presenter, final CustomerGateway gateway) {
    this.presenter = presenter;
    this.gateway = gateway;
  }

  @Override
  public CustomerResponseModel login(final CustomerRequestModel requestModel) {
    Optional<CustomerDataMapper> savedCustomer = gateway.findByUsername(requestModel.getUsername());
    if (savedCustomer.isEmpty()) {
      return presenter.prepareFailView("Customer does not exist.");
    }

    final CustomerDataMapper customer = savedCustomer.get();
    if (!requestModel.getPassword().equals(customer.getPassword())) {
      return presenter.prepareFailView("Customer password is wrong.");
    }

    CustomerResponseModel accountResponseModel = new CustomerResponseModel(customer.getUsername());
    return presenter.prepareSuccessView(accountResponseModel);
  }
}
