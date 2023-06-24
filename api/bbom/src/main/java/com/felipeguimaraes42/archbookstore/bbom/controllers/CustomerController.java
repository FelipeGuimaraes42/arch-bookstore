package com.felipeguimaraes42.archbookstore.bbom.controllers;

import static java.util.Objects.nonNull;

import com.felipeguimaraes42.archbookstore.bbom.domains.Customer;
import com.felipeguimaraes42.archbookstore.bbom.services.LoginService;
import com.felipeguimaraes42.archbookstore.bbom.services.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {
  private final LoginService loginService;
  private final RegisterService registerService;

  public CustomerController(
      final LoginService loginService, final RegisterService registerService) {
    this.loginService = loginService;
    this.registerService = registerService;
  }

  @PostMapping("/login")
  public ResponseEntity<Customer> getCustomer(@RequestBody final Customer requestCustomer) {
    final Customer customer = loginService.execute(requestCustomer);
    if (nonNull(customer)) {
      customer.setPassword(null);
      return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping("/register")
  public ResponseEntity<Void> registerCustomer(@RequestBody final Customer requestCustomer) {
    final Customer customer = registerService.execute(requestCustomer);
    if (nonNull(customer)) {
      return new ResponseEntity<>(HttpStatus.CREATED);
    }
    return new ResponseEntity<>(HttpStatus.CONFLICT);
  }
}
