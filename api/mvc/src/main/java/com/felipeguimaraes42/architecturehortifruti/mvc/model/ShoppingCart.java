package com.felipeguimaraes42.architecturehortifruti.mvc.model;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ShoppingCart {
  private Set<CartItem> cartItems;

  public ShoppingCart() {
    this.cartItems = new HashSet<>();
  }
}
