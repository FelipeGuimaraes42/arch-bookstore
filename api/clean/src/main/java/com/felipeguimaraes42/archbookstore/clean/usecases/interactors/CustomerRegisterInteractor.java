package com.felipeguimaraes42.archbookstore.clean.usecases.interactors;

import com.felipeguimaraes42.archbookstore.clean.entities.customer.Customer;
import com.felipeguimaraes42.archbookstore.clean.entities.customer.CustomerFactory;
import com.felipeguimaraes42.archbookstore.clean.usecases.boundaries.CustomerRegisterBoundary;
import com.felipeguimaraes42.archbookstore.clean.usecases.gateways.CustomerGateway;
import com.felipeguimaraes42.archbookstore.clean.usecases.models.customer.CustomerGatewayRequestModel;
import com.felipeguimaraes42.archbookstore.clean.usecases.models.customer.CustomerRequestModel;
import com.felipeguimaraes42.archbookstore.clean.usecases.models.customer.CustomerResponseModel;
import com.felipeguimaraes42.archbookstore.clean.usecases.presenters.CustomerPresenter;

public class CustomerRegisterInteractor implements CustomerRegisterBoundary {
  private final CustomerPresenter presenter;
  private final CustomerFactory factory;
  private final CustomerGateway gateway;

  public CustomerRegisterInteractor(
      final CustomerPresenter presenter,
      final CustomerFactory factory,
      final CustomerGateway gateway) {
    this.presenter = presenter;
    this.factory = factory;
    this.gateway = gateway;
  }

  @Override
  public CustomerResponseModel register(final CustomerRequestModel requestModel) {
    if (gateway.findByUsername(requestModel.getUsername()).isPresent()) {
      return presenter.prepareFailView("Customer already exists.");
    }

    final Customer customer =
        factory.create(requestModel.getUsername(), requestModel.getPassword());
    if (!customer.isPasswordValid()) {
      return presenter.prepareFailView("Customer password must have more than 5 characters.");
    }

    final CustomerGatewayRequestModel customerGatewayRequestModel =
        new CustomerGatewayRequestModel(customer.getUsername(), customer.getPassword());

    gateway.save(customerGatewayRequestModel);

    final CustomerResponseModel accountResponseModel =
        new CustomerResponseModel(customer.getUsername());
    return presenter.prepareSuccessView(accountResponseModel);
  }
}
