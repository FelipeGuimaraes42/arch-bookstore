package com.felipeguimaraes42.archbookstore.mvc.controller.controllers;

import static java.util.Objects.isNull;

import com.felipeguimaraes42.archbookstore.mvc.controller.services.GetCustomerService;
import com.felipeguimaraes42.archbookstore.mvc.controller.services.RegisterCustomerService;
import com.felipeguimaraes42.archbookstore.mvc.model.Customer;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CustomerController {
  private final GetCustomerService getCustomerService;
  private final RegisterCustomerService registerCustomerService;

  public CustomerController(
      final GetCustomerService getCustomerService,
      final RegisterCustomerService registerCustomerService) {
    this.getCustomerService = getCustomerService;
    this.registerCustomerService = registerCustomerService;
  }

  @GetMapping("/signin")
  public ModelAndView getCustomer() {
    ModelAndView mv = new ModelAndView("view/signin");
    mv.addObject("success", -1);
    return mv;
  }

  @PostMapping("/login")
  public ModelAndView getCustomer(
      @ModelAttribute final Customer requestCustomer, final HttpSession session) {
    final Customer customer = getCustomerService.execute(requestCustomer);
    if (isNull(customer)) {
      ModelAndView mv = new ModelAndView("view/signin");
      mv.addObject("success", 0);
      return mv;
    }
    session.setAttribute("username", customer.getUsername());
    session.getAttribute("username");
    return new ModelAndView("redirect:/");
  }

  @GetMapping("/signup")
  public ModelAndView registerCustomer() {
    ModelAndView mv = new ModelAndView("view/signup");
    mv.addObject("success", -1);
    return mv;
  }

  @PostMapping("/register")
  public ModelAndView registerCustomer(@ModelAttribute final Customer customer) {
    ModelAndView mv = new ModelAndView("view/signup");
    mv.addObject("success", 1);
    try {
      registerCustomerService.execute(customer);
    } catch (Exception e) {
      mv.addObject("success", 0);
    }
    return mv;
  }

  @GetMapping("/logout")
  public ModelAndView logout(final HttpSession session) {
    session.invalidate();
    return new ModelAndView("redirect:/");
  }
}
