package com.felipeguimaraes42.architecturehortifruti.mvc.controller.dtos;

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
public class HortifrutiDTO {
  private Long id;
  private String name;
  private String description;
  private Double price;
  private String category;
  private String image;
}
