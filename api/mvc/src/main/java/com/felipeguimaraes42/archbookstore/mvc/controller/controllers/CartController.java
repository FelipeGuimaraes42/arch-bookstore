package com.felipeguimaraes42.archbookstore.mvc.controller.controllers;

import com.felipeguimaraes42.archbookstore.mvc.controller.dtos.CartItemDTO;
import com.felipeguimaraes42.archbookstore.mvc.controller.dtos.ShoppingCartDTO;
import com.felipeguimaraes42.archbookstore.mvc.controller.services.AddCartService;
import com.felipeguimaraes42.archbookstore.mvc.controller.services.GetCartService;
import com.felipeguimaraes42.archbookstore.mvc.controller.services.UpdateCartService;
import jakarta.servlet.http.HttpSession;
import java.util.Objects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("cart")
public class CartController {
  private final GetCartService getCartService;
  private final UpdateCartService updateCartService;
  private final AddCartService addCartService;

  public CartController(
      final GetCartService getCartService,
      final UpdateCartService updateCartService,
      final AddCartService addCartService) {
    this.getCartService = getCartService;
    this.updateCartService = updateCartService;
    this.addCartService = addCartService;
  }

  @GetMapping
  public ModelAndView getCart(final HttpSession httpSession) {
    final String username = (String) httpSession.getAttribute("username");
    if (Objects.nonNull(username)) {
      ShoppingCartDTO cart = getCartService.execute(username);
      ModelAndView mv = new ModelAndView("view/cart");
      mv.addObject("cart", cart);
      mv.addObject("empty", false);
      double totalCartPrice = 0.0;
      for (CartItemDTO item : cart.getCartItems()) {
        totalCartPrice += item.getBook().getPrice() * item.getQuantity();
      }
      mv.addObject("totalPrice", totalCartPrice);

      if (cart.getCartItems().isEmpty()) {
        mv.addObject("empty", true);
      }
      return mv;
    }
    return new ModelAndView("redirect:/signin");
  }

  @PostMapping("insert")
  public ModelAndView addCartItem(
      @RequestParam("item_id") final Long itemId, final HttpSession httpSession) {
    final String username = (String) httpSession.getAttribute("username");

    if (Objects.nonNull(username)) {
      addCartService.execute(username, itemId);
      return new ModelAndView("redirect:/");
    }
    return new ModelAndView("redirect:/signin");
  }

  @PostMapping(value = "update", params = "action=update")
  public ModelAndView updateCartItem(
      @RequestParam("item_id") final Long itemId,
      @RequestParam("quantity") final Integer quantity,
      final HttpSession httpSession) {
    final String username = (String) httpSession.getAttribute("username");
    updateCartService.execute(username, itemId, quantity);
    return new ModelAndView("redirect:/cart");
  }

  @PostMapping(value = "update", params = "action=delete")
  public ModelAndView deleteCartItem(
      @RequestParam("item_id") final Long itemId, final HttpSession httpSession) {
    final String username = (String) httpSession.getAttribute("username");
    updateCartService.execute(username, itemId, 0);
    return new ModelAndView("redirect:/cart");
  }
}
