package com.felipeguimaraes42.archbookstore.bbom.controllers;

import com.felipeguimaraes42.archbookstore.bbom.domains.Customer;
import com.felipeguimaraes42.archbookstore.bbom.services.LoginService;
import com.felipeguimaraes42.archbookstore.bbom.services.RegisterService;
import java.util.Objects;
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
  public ResponseEntity<Void> getCustomer(@RequestBody final Customer requestCustomer) {
    final Customer execute = loginService.execute(requestCustomer);
    if (Objects.nonNull(execute)) {
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping("/register")
  public ResponseEntity<Customer> registerCustomer(@RequestBody final Customer customer) {
    return new ResponseEntity<>(registerService.execute(customer), HttpStatus.CREATED);
  }
}
