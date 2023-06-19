package com.felipeguimaraes42.archbookstore.mvc.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CartItemDTO {
  private Long id;
  private HortifrutiDTO hortifruti;
  private Integer quantity;
}
