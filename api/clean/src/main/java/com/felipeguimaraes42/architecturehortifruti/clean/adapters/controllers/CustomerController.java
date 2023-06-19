package com.felipeguimaraes42.architecturehortifruti.clean.adapters.controllers;

import static java.util.Objects.nonNull;

import com.felipeguimaraes42.architecturehortifruti.clean.usecases.boundaries.CustomerLoginBoundary;
import com.felipeguimaraes42.architecturehortifruti.clean.usecases.boundaries.CustomerRegisterBoundary;
import com.felipeguimaraes42.architecturehortifruti.clean.usecases.models.customer.CustomerRequestModel;
import com.felipeguimaraes42.architecturehortifruti.clean.usecases.models.customer.CustomerResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("customer")
public class CustomerController {
  private final CustomerRegisterBoundary customerRegisterBoundary;
  private final CustomerLoginBoundary customerLoginBoundary;

  public CustomerController(
      final CustomerRegisterBoundary customerRegisterBoundary,
      final CustomerLoginBoundary customerLoginBoundary) {
    this.customerRegisterBoundary = customerRegisterBoundary;
    this.customerLoginBoundary = customerLoginBoundary;
  }

  @PostMapping("/login")
  public ResponseEntity<Void> getCostumer(@RequestBody final CustomerRequestModel customer) {
    final CustomerResponseModel execute = customerLoginBoundary.login(customer);
    if (nonNull(execute)) {
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping("/register")
  public ResponseEntity<Void> registerCostumer(@RequestBody final CustomerRequestModel customer) {
    final CustomerResponseModel execute = customerRegisterBoundary.register(customer);
    if (nonNull(execute)) {
      return new ResponseEntity<>(HttpStatus.CREATED);
    }
    return new ResponseEntity<>(HttpStatus.CONFLICT);
  }
}
