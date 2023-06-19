package com.felipeguimaraes42.architecturehortifruti.none.domains;

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
public class HortifrutiCart {
  private Hortifruti hortifruti;
  private Long quantity;
}
