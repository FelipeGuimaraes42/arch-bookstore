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
public class Hortifruti {
  private String name;
  private String description;
  private Double price;
  private String category;
  private String image;
}
