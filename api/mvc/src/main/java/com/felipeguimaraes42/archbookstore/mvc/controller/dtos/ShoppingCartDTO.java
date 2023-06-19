package com.felipeguimaraes42.archbookstore.mvc.controller.dtos;

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
public class ShoppingCartDTO {
  private Long id;
  private Set<CartItemDTO> cartItems;

  public ShoppingCartDTO() {
    this.cartItems = new HashSet<>();
  }
}
