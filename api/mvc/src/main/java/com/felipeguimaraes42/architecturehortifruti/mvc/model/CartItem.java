package com.felipeguimaraes42.architecturehortifruti.mvc.model;

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
public class CartItem {
  private Hortifruti hortifruti;
  private Integer quantity;
}
